<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width">
        <title>Test</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="header.jsp">
            <jsp:param name="active" value="book"/>
        </jsp:include>

        <div class="container">	
            <h1>Modifier un livre</h1>
            <br>

            <!-- Gestion des erreurs -->
            <c:if test="${msg_error != null}">
                <div class="alert alert-warning" role="alert">${msg_error}</div>
            </c:if>

            <!-- Si message succès -->
            <c:if test="${msg_success != null}">
                <div class="alert alert-success "role="alert">${msg_success}</div>
            </c:if> 

            <!-- Formulaire -->
            <form action="" method="post" id="update">
                <div class="form-group">
                    <label for="isbn">ISBN*</label>
                    <input type="number" class="form-control" name="isbn" value="${book.isbn}">
                </div>
                <div class="form-group">
                    <label for="title">Titre*</label>
                    <input type="text" class="form-control" name="title" value="${fn:escapeXml(book.title)}">
                </div>
                <div class="form-group">
                    <label for="pseudo">Prix*</label>
                    <input type="number" class="form-control" name="price" value="${book.price}">
                </div>
                <p>* Champs obligatoires</p>
                <button type="submit" class="btn btn-primary">Enregistrer</button>
            </form>
        </div>
    </body>
</html>