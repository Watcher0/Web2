<jsp:useBean id="table" scope="session" class="view.TableValue" />
<%@ page import="model.TableDate" %>
<%@ page import="java.util.List" %>
<%@ page import="view.TableValue" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
    <title>Laba2</title>
</head>
<body>
<table width="1000" cellspacing="4" class="main">
    <tr>
        <td  colspan="2" id="shapka"><h3 class="shapka">Marakushev Mikhail. P32091</h3></td>
    </tr>
    <tr>
        <td align="center" class="coordin">
            <canvas id="example" width="300" height="300">

            </canvas>
        </td>
        <td class="shapka">
            <form method="POST" name="coor_form" class="forma">
                <h4 class="form">Enter X:</h4>
                <input type="checkbox" name="coor_x" value="-2" class="coor_x">-2
                <input type="checkbox" name="coor_x" value="-1.5" class="coor_x">-1.5
                <input type="checkbox" name="coor_x" value="-1" class="coor_x">-1
                <input type="checkbox" name="coor_x" value="-0.5" class="coor_x">-0.5
                <input type="checkbox" name="coor_x" value="0" class="coor_x">0
                <input type="checkbox" name="coor_x" value="0.5" class="coor_x">0.5
                <input type="checkbox" name="coor_x" value="1" class="coor_x">1
                <input type="checkbox" name="coor_x" value="1.5" class="coor_x">1.5
                <input type="checkbox" name="coor_x" value="2" class="coor_x">2
                <p class="error" id="error_x"></p>
                <h4 class="form">Enter Y:</h4>
                <input type="text" maxlength="5" name="coor_y" placeholder="[-5..3]" class="coor_y">
                <p class="error" id="error_y"></p>
                <h4 class="form">Enter R:</h4>
                <input type="checkbox" name="value_R" value="1" class="value_r">1
                <input type="checkbox" name="value_R" value="1.5" class="value_r">1.5
                <input type="checkbox" name="value_R" value="2" class="value_r">2
                <input type="checkbox" name="value_R" value="2.5" class="value_r">2.5
                <input type="checkbox" name="value_R" value="3" class="value_r">3
                <p class="error" id="error_r"></p>
                <br><br>
                <input type="submit" value="Send" name="send" id="button">
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="shapka">
            <table cellspacing="3" class="result">
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>World time</th>
                    <th>Execution time</th>
                    <th>Hit/Miss</th>
                </tr>
                ${table.table}
            </table>
        </td>
    </tr>
</table>
<script type="text/javascript" src="js/valid.js"></script>
<script type="text/javascript" src="js/canvas.js"></script>
</body>
</html>
