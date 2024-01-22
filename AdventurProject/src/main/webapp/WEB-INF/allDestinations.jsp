<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<title>Adventure Home Page</title>
<link rel='stylesheet' href='/css/home.css' type='text/css' media='all' />
<style>
        body {
            background-color: #f8f9fa; 
        }

        .fancy-heading {
            font-family: 'Pacifico', cursive; 
            font-size: 2.5rem; 
            color: #007bff; 
            text-align: center; 
            margin-top: 50px; 
             margin-bottom: 100px; 
        }
    </style>


</head>

<body>
	<!-- Navbar -->
	<nav
		class="navbar navbar-expand-xl navbar-light py-1 shadow-lg p-3 mb-5 bg-body rounded"
		style="background-color: #e3f2fd;">
		<div class="container-fluid">

			<a class="navbar-brand " href="/plan"> <img
				src="https://media.discordapp.net/attachments/1197447314848100362/1197467387360989254/adventurLogo.jpg?ex=65bb5f69&is=65a8ea69&hm=37dd6bb12ee3faf35ce8058f47d3bbe1a1fb3b15b77a53188f04d7b8c393bf20&=&format=webp&width=1062&height=662"
				alt="" width="60" height="35" class="d-inline-block align-text-top">
				
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarLight"
				aria-controls="navbarLight" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarLight">
				<div class="d-flex mx-auto">
					<ul class="navbar-nav mb-2 mb-xl-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-house-heart"
									viewBox="0 0 16 16">
                                    <path
										d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982" />
                                    <path
										d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z" />
                                </svg> Home
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-person-raised-hand"
									viewBox="0 0 16 16">
                                    <path
										d="M6 6.207v9.043a.75.75 0 0 0 1.5 0V10.5a.5.5 0 0 1 1 0v4.75a.75.75 0 0 0 1.5 0v-8.5a.25.25 0 1 1 .5 0v2.5a.75.75 0 0 0 1.5 0V6.5a3 3 0 0 0-3-3H6.236a1 1 0 0 1-.447-.106l-.33-.165A.83.83 0 0 1 5 2.488V.75a.75.75 0 0 0-1.5 0v2.083c0 .715.404 1.37 1.044 1.689L5.5 5c.32.32.5.754.5 1.207" />
                                    <path
										d="M8 3a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3" />
                                </svg> Services
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-pin-map-fill"
									viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
										d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8z" />
                                    <path fill-rule="evenodd"
										d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z" />
                                </svg> Places
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/about"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-person-lines-fill"
									viewBox="0 0 16 16">
                                    <path
										d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5m.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1z" />
                                </svg> Contact Us
						</a></li>
					</ul>
				</div>

			</div>
			<div class="d-flex mx-auto">
				<form class="search-bar d-flex mx-auto">
					<input class="form-control border border-info" type="search"
						placeholder="Explore (o.o) " aria-label="Search">
					<button class="btn btn-outline-primary" type="submit">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path
								d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415
                            -1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
                        </svg>
					</button>
				</form>
			</div>

			<ul class="navbar-nav">
				<li class="nav-link"><a class="btn btn-fancy" href="/logout">Log
						Out</a></li>
			</ul>
		</div>
	</nav>







	<!-- Content Section -->
	<div class="container mt-5">
	<h1 class="fancy-heading">Adventure Destinations
	</h1>
	
		<div class="row">
			<c:forEach var="destination" items="${destinations}">
				<div class="col-md-4 mb-4">

					<div class="card h-100 card-hover">
						<img src="${destination.image}" class="card-img-top"
							alt="Card Image">
						<div class="card-body">
							<h5 class="card-title">${destination.destinationName}</h5>
							<p class="card-text">${destination.description}</p>
							<a class="btn btn-fancy" href="/destinations/${destination.id}">
								View More</a>
						</div>
					</div>

				</div>
			</c:forEach>


		</div>
	</div>


	<!-- https://static.tacdn.com/img2/tc/hero/hotels_hero_2023-c1.png -->
	<div class="container mt-5">
		<hr class="featurette-divider">

		<div class="row featurette shadow-lg p-3 mb-5 bg-body rounded">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Top Hotels <span class="text-muted"> - World </span>
				</h2>
				<p class="card-text">We award Travelers Choice Best of the Best
					to hotels with a high volume of above-and-beyond reviews and
					opinions from our community over a 12-month period. Each winner has
					passed our rigorous trust and safety standards. Fewer than 1% of
					Tripadvisors 8 million listings are awarded Best of the Best,
					signifying the highest level of excellence in hospitality.
			</div>
			<div class="col-md-5 ">
				<img class="featurette-image img-fluid mx-auto"
					src="https://static.tacdn.com/img2/tc/hero/hotels_hero_2023-c1.png"
					data-holder-rendered="true">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette shadow-lg p-3 mb-5 bg-body rounded">
			<div class="col-md-7 order-md-2">
				<h2 class="featurette-heading">
					Fine Dining <span class="text-muted">- World</span>
				</h2>
				<p class="card-text">We award Travelers Choice Best of the Best
					to restaurants with a high volume of above-and-beyond reviews and
					opinions from our community over a 12-month period. Each winner has
					passed our rigorous trust and safety standards. Fewer than 1% of
					Tripadvisor’s 8 million listings are awarded Best of the Best,
					signifying the highest level of excellence in travel.</p>
			</div>
			<div class="col-md-5 order-md-1">
				<img class="featurette-image img-fluid mx-auto"
					data-src="holder.js/500x500/auto" alt="500x500"
					src="https://images.unsplash.com/photo-1414235077428-338989a2e8c0?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
					data-holder-rendered="true">
				<!-- style="width: 500px; height: 500px; -->
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette shadow-lg p-3 mb-5 bg-body rounded">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Top things to do <span class="text-muted">and attractions</span>
				</h2>
				<p class="card-text">Explore the best things to do around the
					world on Tripadvisor to get recommendations and read reviews from
					those who have been there before. From family-friendly activities
					and adventure excursions to city tours, museums and iconic
					attractions, discover amazing experiences near and far to start
					planning your next trip.</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-fluid mx-auto"
					src="https://www.bontravelindia.com/wp-content/uploads/2021/12/Best-Adventure-Sports-Activities-in-India.jpg">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->

	</div>
	<!-- /.container -->


	<!-- Footer Section -->
	<footer class="bg-light text-center text-lg-start mt-5">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<nav class="navbar navbar-expand-xl navbar-light py-1"
						style="background-color: #e3f2fd;">
						<div class="container-fluid ">
							<div
								class="collapse navbar-collapse show d-flex justify-content-around"
								id="navbarLight">
								<ul class="navbar-nav">
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="/"> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-house-heart"
												viewBox="0 0 16 16">
                                                <path
													d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982" />
                                                <path
													d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z" />
                                            </svg> Home
									</a></li>
									<li class="nav-item"><a class="nav-link" href="#"><svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-person-raised-hand"
												viewBox="0 0 16 16">
                                            <path
													d="M6 6.207v9.043a.75.75 0 0 0 1.5 0V10.5a.5.5 0 0 1 1 0v4.75a.75.75 0 0 0 1.5 0v-8.5a.25.25 0 1 1 .5 0v2.5a.75.75 0 0 0 1.5 0V6.5a3 3 0 0 0-3-3H6.236a1 1 0 0 1-.447-.106l-.33-.165A.83.83 0 0 1 5 2.488V.75a.75.75 0 0 0-1.5 0v2.083c0 .715.404 1.37 1.044 1.689L5.5 5c.32.32.5.754.5 1.207" />
                                            <path
													d="M8 3a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3" />
                                        </svg> Services</a></li>
									<li class="nav-item"><a class="nav-link" href="#"><svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-pin-map-fill"
												viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
													d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8z" />
                                            <path fill-rule="evenodd"
													d="M4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z" />
                                        </svg> Places</a></li>
									<li class="nav-item"><a class="nav-link" href="/about"><svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-person-lines-fill"
												viewBox="0 0 16 16">
                                            <path
													d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5m.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1z" />
                                        </svg> Contact Us</a></li>
								</ul>
							</div>
						</div>
					</nav>
					<div class="col-md-8 mx-auto">
						<div class="jumbotron text-center">

							<p class="card-text">Discover new content by category
								throughout the year, so keep checking back for the latest.</p>
							<hr class="my-4">
							<p>call-to-action here. it's our pleasure to help.</p>
							<a href="#" title="Facebook" aria-label="Facebook"><svg
									viewBox="0 0 24 24" width="24px" height="24px"
									class="d Vb UmNoP">
									<path
										d="M12.001 2.061C6.478 2.061 2 6.537 2 12.061c0 4.993 3.661 9.132 8.445 9.879v-6.99H7.89v-2.889h2.556l.001-2.203c0-2.506 1.484-3.896 3.769-3.896 1.095 0 2.23.21 2.23.21v2.445h-1.253c-1.242 0-1.639.777-1.639 1.568l.003 1.876h2.777l-.444 2.889h-2.333v6.99C18.34 21.192 22 17.054 22 12.061c0-5.524-4.477-10-9.999-10z"></path></svg></a>
							<a href="#" rel="noopener" class="HqkqA Cl _F bYExr"
								title="Twitter" aria-label="Twitter"><svg
									viewBox="0 0 24 24" width="24px" height="24px"
									class="d Vb UmNoP">
									<path
										d="M2 18.1c2.2.2 4.3-.5 5.9-1.899-1.2-.101-3.6-2.4-4-2.9h1.6c-1.9-.5-3.2-2.2-3.2-4.1.6.099 1.2.299 1.7.499h.2C2.7 8.3 2.2 6 3.1 4.1c2.1 2.6 5.3 4.2 8.6 4.4V7.4c.1-2.2 2-4 4.2-4 .9 0 1.7.3 2.4.8.4.3.8.3 1.2.2l1.9-.7c-.4.9-.9 1.6-1.6 2.3.601-.1 1.3-.4 1.9-.5l.3.2c-.6.5-1.2 1.1-1.7 1.5-.1.3-.2.7-.2 1.1 0 1.9-.5 3.8-1.3 5.601A11.982 11.982 0 019.5 20.1c-2.4.2-4.9-.199-7-1.3l-.5-.7"></path></svg></a>
							<a href="#" rel="noopener" class="HqkqA Cl _F bYExr"
								title="Instagram" aria-label="Instagram"><svg
									viewBox="0 0 24 24" width="24px" height="24px"
									class="d Vb UmNoP">
									<path
										d="M21.938 7.9c0-.8-.199-1.6-.5-2.4-.5-1.4-1.5-2.5-2.9-3-.799-.3-1.6-.4-2.4-.5h-4.099c-1.4 0-2.8 0-4.2.1-.8 0-1.6.2-2.3.5-1.3.5-2.4 1.5-2.9 2.8-.3.8-.5 1.6-.5 2.5 0 1.1-.1 1.4-.1 4.1-.1 1.4-.1 2.7 0 4.1 0 .801.2 1.601.5 2.4.5 1.3 1.6 2.4 2.9 2.9.8.3 1.6.399 2.4.5 1.4.1 2.8.1 4.2.1s2.8 0 4.099-.1c.801 0 1.602-.2 2.4-.5a5.17 5.17 0 002.9-2.9c.301-.8.398-1.6.5-2.4 0-1.1.1-1.399.1-4.1s-.1-3.1-.1-4.1zM20.137 16c0 .6-.1 1.3-.299 1.9-.301.898-1 1.6-1.9 1.898-.6.201-1.301.301-1.9.301-1.1 0-1.4.102-4 .102-1.3 0-2.7 0-4-.102-.6 0-1.2-.1-1.9-.3-.9-.3-1.6-1-1.9-1.899-.3-.601-.4-1.2-.4-1.9 0-1.1-.1-1.4-.1-4 0-1.3 0-2.7.1-4 .1-.6.2-1.3.3-1.9.3-.9 1-1.6 1.9-1.9.7-.2 1.3-.3 2-.3 1.1 0 1.4-.1 4-.1 1.3 0 2.701 0 4 .1.6 0 1.301.1 1.9.3.898.3 1.6 1 1.898 1.9.201.6.301 1.3.301 1.9 0 1.1.102 1.4.102 4-.001 2.6-.102 3-.102 4z"></path>
									<path
										d="M12.138 6.9c-2.9 0-5.1 2.3-5.1 5.1s2.3 5.1 5.1 5.1 5.101-2.3 5.101-5.1-2.301-5.1-5.101-5.1zm0 8.4c-1.8 0-3.3-1.5-3.3-3.3s1.5-3.3 3.3-3.3c1.8 0 3.2 1.5 3.3 3.3 0 1.8-1.5 3.3-3.3 3.3zM17.438 5.5c-.699 0-1.199.5-1.199 1.2s.5 1.2 1.199 1.2 1.199-.5 1.199-1.2-.5-1.2-1.199-1.2z"></path></svg></a>


						</div>
					</div>
					<div class="d-flex justify-content-center align-items-center mt-3">
						<a class="navbar-brand" href="#"> <img
							src="https://media.discordapp.net/attachments/1197447314848100362/1197467387360989254/adventurLogo.jpg?ex=65bb5f69&is=65a8ea69&hm=37dd6bb12ee3faf35ce8058f47d3bbe1a1fb3b15b77a53188f04d7b8c393bf20&=&format=webp&width=1062&height=662"
							alt="" width="60" height="35"
							class="d-inline-block align-text-top"> © 2024 Adventure
						</a>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>


</body>

</html>
