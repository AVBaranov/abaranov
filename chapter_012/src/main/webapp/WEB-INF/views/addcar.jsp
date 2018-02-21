<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>add new car</title>
    <style type="text/css">
        body {
            background-color: gainsboro;
        }

        .block1 {
            width: 300px;
            background: lavender;
            padding: 10px;
            padding-right: 20px;
        }

        .block2 {
            width: 70px;
            background: bisque;
            padding: 10px;
            padding-right: 20px;
        }

        .block3 {
            width: 60px;
            background: crimson;
            padding: 4px;
        }

    </style>
</head>
<body>

<hr />

<div>
    <form action="/addcar.do" method="post" enctype="multipart/form-data">

        <div class="block1">
            <b style="font-style: oblique; font-size: 20px; color: azure">model</b>
            <br/>
            <select name="model" style="width:200px">
                <option value="toyota">toyota</option>
                <option value="hyundai">hyundai</option>
                <option value="bmw">bmw</option>
                <option value="mercedes">mercedes</option>
            </select>
            <br/>

            <b style="font-style: oblique; font-size: 20px; color: azure">bodytype</b>
            <br/>
            <select name="bodytype" style="width:200px">
                <option value="sedan">sedan</option>
                <option value="hatchback">hatchback</option>
                <option value="crossover">crossover</option>
                <option value="cabriolet">cabriolet</option>
            </select>

            <br/>
            <b style="font-style: oblique; font-size: 20px; color: azure">transmission</b>
            <select name="transmission" style="width:200px">
                <option value="AT">AT</option>
                <option value="MT">MT</option>
            </select>

            <br/>
            <b style="font-style: oblique; font-size: 20px; color: azure">engine</b>
            <br/>
            <select name="engine" style="width:200px">
                <option value="1.4 Optima">1.4 Optima</option>
                <option value="1.6 Optima">1.6 Optima</option>
            </select>

            <br/>
            <br/>
            <input type="checkbox" name="soldcar" value="true" class="chk">sold
            <br/>
            <table>
                <tr>
                    <td style="font-style: oblique; color: antiquewhite; font-family: 'Angsana New'; font-size: 30px"><input type="file" name="file" multiple="multiple"></td>

                </tr>
            </table>
            <br/><br/>

            <div class="block3">
                <input type="submit" value="add car">
            </div>
            <br/>
        </div>
    </form>
</div>

<div class="block2">
    <form action="/getcars.do" method="get">
        <input type="submit" value="show cars">
    </form>
</div>

<br>
<hr />
<span style="color: red; font-size: 14px;">${msg}</span>

</body>
</html>