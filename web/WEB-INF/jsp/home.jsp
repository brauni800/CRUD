<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8">
        <title>Un 10 plox</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.bundle.min.js" integrity="sha384-3ziFidFTgxJXHMDttyPJKDuTlmxJlwbSkojudK/CkRqKDOmeSbN6KLrGdrBQnT2n" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <p>
                    <h1>Un 10 plox</h1>
                    <a href = "<c:url value = "add.htm"/>" class = "btn btn-success">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        Agregar
                    </a>
                </p>
                    
                <table class = "table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Edad</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${datos}" var = "dato">
                            <tr>
                                <td><c:out value = "${dato.id}"/></td>
                                <td><c:out value = "${dato.nombre}"/></td>
                                <td><c:out value = "${dato.telefono}"/></td>
                                <td><c:out value = "${dato.correo}"/></td>
                                <td><c:out value = "${dato.edad}"/></td>
                                <td>
                                    <a href = "<c:url value = "edit.htm?id=${dato.id}"/>">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    </a>
                                    <a href = "<c:url value = "delete.htm?id=${dato.id}"/>">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
