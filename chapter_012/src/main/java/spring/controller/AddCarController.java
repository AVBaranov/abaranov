package spring.controller;

import java.io.*;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.models.*;

/**
 * Created by Андрей on 20.02.2018.
 */
@Controller
public class AddCarController {
    @RequestMapping(value = "/addcar", method = RequestMethod.GET)
    public String fileUploadForm(Model model) {
        return "addcar";
    }

    // Handling multiple files upload request
    @RequestMapping(value = "/addcar", method = RequestMethod.POST)
    public String multipleFileUpload(@RequestParam(value = "file") MultipartFile[] files,
                                     Model model,
                                     @RequestParam(value = "model") String carmodel,
                                     @RequestParam(value = "bodytype") String bodytype,
                                     @RequestParam(value = "transmission") String transmission,
                                     @RequestParam(value = "engine") String engine) throws IOException {

        // Save file on system
        for (MultipartFile file : files) {
            if (!file.getOriginalFilename().isEmpty()) {
                //create folder to store files
                File filepath = new File("C:/UploadFiles", file.getOriginalFilename());
                filepath.getParentFile().mkdirs();
                //store file into created folder
                try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filepath));) {
                    outputStream.write(file.getBytes());
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                model.addAttribute("msg", "Please select at least one file..");
                return "addcar";
            }
        }
        model.addAttribute("msg", "Multiple files uploaded successfully.");

        Engine engineTest = new Engine();
        engineTest.setModel(engine);
        Carbody carbodyTest = new Carbody();
        carbodyTest.setType(bodytype);
        Transmission transmis = new Transmission();
        transmis.setType(transmission);
        Car car = new Car(carmodel, engineTest, carbodyTest, transmis, true);
        new CarDaoStorageAnnotate().create(car);
        return "redirect:addcar.do";
    }

    @RequestMapping(value = "/getcars", method = RequestMethod.GET)
    public String getCarInJson(Model model) {
        List<Car> cars = new CarDaoStorageAnnotate().read();
        model.addAttribute("cars", cars);
        return "showcars";
    }

}

