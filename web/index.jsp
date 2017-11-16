<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibliothèque - Accueil</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">        <!-- Latest compiled and minified JavaScript -->
        <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

    </head>
    <body>
        
        <jsp:include page="header.jsp">
	    <jsp:param name="active" value="home"/>
	</jsp:include>
        
        <div class="container">
                
        <!-- Si message erreur -->
        <c:if test="${msg_error != null}">
		<div class="alert alert-danger "role="alert">${msg_error}</div>
        </c:if>
        <!-- Si message succès -->
        <c:if test="${msg_success != null}">
		<div class="alert alert-success "role="alert">${msg_success}</div>
        </c:if> 
        <h1>Liste des livres</h1>
        <br/>
        <c:if test="${books.size() > 0}">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>ISBN</th>
                    <th>Nom du livre</th>
                    <th>Prix</th>
                    <th>Auteur(s)</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.getTitle()}</td>
                        <td>${book.getPrice()}</td>
                        <td>
                            <c:forEach items="${book.getAuthors()}" var="bookauthor">
                                 ${bookauthor.getFirstName()} ${bookauthor.getLastName()}
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/INF2_JPA/edit?id=${book.getIsbn()}" class="btn btn-secondary btn-sm">
                                <span class="oi oi-pencil"></span>
                            </a>
                            <form action="" method="post" id="del" style="display:inline-block;">
                            <button type="submit" name="id_del" class="btn-sm btn btn-danger btn-unique-delete" value="${ book.getIsbn() }">
                                <span class="oi oi-trash"></span>
                            </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        </div>
    </body>
</html>