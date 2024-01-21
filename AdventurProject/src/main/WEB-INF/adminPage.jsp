<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>        
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Fira+Mono:wght@650&display=swap" rel="stylesheet">
		<style>
        .btn-fancy {
            background-color: #5a5a5a;
            color: #fff;
            transition: background-color 0.3s ease;
        }
        .btn-fancy:hover {
            background-color: #5a5a5a;
        }
        .search-bar {
        border: none;
        border-radius: 20px;
        padding: 5px 10px;
	    }
	    .search-bar input {
	        border: none;
	        color: #fff;
	    }
	    .search-bar button {
	        
	        border: none;
	        border-radius: 20px;
	        margin-left: 5px;
	        transition: background-color 0.3s ease;
	    }
	    .search-bar button:hover {
	        background-color: #5a5a5a;
	    }
	    .carousel-inner img {
	        max-height: 400px;
	        width: auto;
	    }
	    .btn-fancy {
	        background-color: #5a5a5a;
	        color: #fff;
	        transition: background-color 0.3s ease;
	    }
	    .btn-fancy:hover {
	        background-color: #5a5a5a;
	    }
	    
	    </style>
	</head>
	<body>
		<!-- Navbar -->
    <nav class="navbar navbar-expand-xl navbar-light py-1" style="background-color: #e3f2fd;">
        <div class="container-fluid">

            <a class="navbar-brand" href="#">
                <img src="https://media.discordapp.net/attachments/1197447314848100362/1197467387360989254/adventurLogo.jpg?ex=65bb5f69&is=65a8ea69&hm=37dd6bb12ee3faf35ce8058f47d3bbe1a1fb3b15b77a53188f04d7b8c393bf20&=&format=webp&width=1062&height=662"
                    alt="" width="60" height="35" class="d-inline-block align-text-top">
                Adventur Planer
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarLight" aria-controls="navbarLight" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarLight">
                <div class="d-flex mx-auto">
                    <ul class="navbar-nav mb-2 mb-xl-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-heart" viewBox="0 0 16 16">
                                    <path d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982"/>
                                    <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"/>
                                </svg> 
                                Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-raised-hand" viewBox="0 0 16 16">
                                    <path d="M6 6.207v9.043a.75.75 0 0 0 1.5 0V10.5a.5.5 0 0 1 1 0v4.75a.75.75 0 0 0 1.5 0v-8.5a.25.25 0 1 1 .5 0v2.5a.75.75 0 0 0 1.5 0V6.5a3 3 0 0 0-3-3H6.236a1 1 0 0 1-.447-.106l-.33-.165A.83.83 0 0 1 5 2.488V.75a.75.75 0 0 0-1.5 0v2.083c0 .715.404 1.37 1.044 1.689L5.5 5c.32.32.5.754.5 1.207"/>
                                    <path d="M8 3a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"/>
                                </svg> 
                                Services
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pin-map-fill" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8z"/>
                                    <path fill-rule="evenodd" d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"/>
                                </svg> 
                                Places
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
                                    <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5m.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1z"/>
                                </svg> 
                                Contact Us
                            </a>
                        </li>
                    </ul>

                    
                </div>
                
            </div>
            <div class="d-flex mx-auto">
                <form class="search-bar d-flex mx-auto">
                    <input class="form-control" type="search" placeholder="Explore (o.o) " aria-label="Search">
                    <button class="btn btn-outline-primary" type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg>
                    </button>
                </form>
            </div>

            <ul class="navbar-nav">
    <li class="nav-link">
        <button class="btn btn-fancy" type="button">Sign Up  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z"/>
            <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z"/>
          </svg></button>
    </li>
</ul>
        </div>
    </nav>

		
		<div class="container mt-5">
	    	<form:form action="/destinations/new" method="post" modelAttribute="destination">
	
		        <!-- Example Input Field -->
		        <div class="form-group">
		            <form:label for="destinationName" path="destinationName">Destination Name:</form:label>
		            <form:input type="text" class="form-control" id="destinationName" path="destinationName" />
		        </div>
		        <div class="form-group">
		            <form:label for="image" path="image">Destination Image:</form:label>
		            <form:input type="text" class="form-control" id="image" path="image" />
		        </div>
				<div class="form-group">
		            <form:label for="description" path="description">Destination Description:</form:label>
		            <form:textarea class="form-control" id="description" path="description" />
		        </div>
		        <!-- Add more input fields as needed -->
		
		        <button type="submit" class="btn btn-primary">Create</button>
	    	</form:form>
		</div>
		
		 <!-- Footer Section -->
	    <footer class="bg-light text-center text-lg-start mt-5">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-12">
	                    <nav class="navbar navbar-expand-xl navbar-light py-1" style="background-color: #e3f2fd;">
	                        <div class="container-fluid ">
	                            <div class="collapse navbar-collapse show d-flex justify-content-around"
	                                id="navbarLight">
	                                <ul class="navbar-nav">
	                                    <li class="nav-item">
	                                        <a class="nav-link active" aria-current="page" href="#">Home</a>
	                                    </li>
	                                    <li class="nav-item">
	                                        <a class="nav-link" href="#">Services</a>
	                                    </li>
	                                    <li class="nav-item">
	                                        <a class="nav-link" href="#">Places</a>
	                                    </li>
	                                    <li class="nav-item">
	                                        <a class="nav-link" href="#">Contact Us</a>
	                                    </li>
	                                </ul>
	                            </div>
	                        </div>
	                    </nav>
	                    <div class="d-flex justify-content-center align-items-center mt-3">
	                        <a class="navbar-brand" href="#">
	                            <img src="https://media.discordapp.net/attachments/1197447314848100362/1197467387360989254/adventurLogo.jpg?ex=65bb5f69&is=65a8ea69&hm=37dd6bb12ee3faf35ce8058f47d3bbe1a1fb3b15b77a53188f04d7b8c393bf20&=&format=webp&width=1062&height=662"
	                                alt="" width="60" height="35" class="d-inline-block align-text-top">
	                            © 2024 Adventure
	                        </a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </footer>
	
	    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
	    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	    crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
	</body>
</html>