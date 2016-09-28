var app = angular.module('VehicleManagement',['ngRoute','pascalprecht.translate'])


app.controller('VehicleManagementController',['searchService','carService','authService','$location','$http','$translate',function(searchService,carService,authService,$location,$http,$translate){
	
	var vm = this;
	this.showWelcome = true;
	this.showSignUp = false;
	this.showSignIn = false;
	this.showProfile = false;
	this.showCars = false;
	this.showAddCar = false;
	this.showStats = false;
	this.showResults = false;
	this.showEditUsers = false;
	this.searchContent  = "";
	this.searchResult = [];
	this.english = true;
	this.clickedSignIn =  false;
	this.macedonian = false;
	this.authService = authService;
	this.user = {
		name : "Aleksandar",
		lastName : "Stanoevski",
		mobile : "070 000 000",
		email : "acestan@gmail.com",
		username : "acestan",
		password : "122345",
		ssid : "2208993111111",
		role : "",
		cars : []}
	this.signInStrings = {
		title : "WELCOME",
		signIn : "Sign In",
		subtitle :  "Enter your User Name and Password",
		username : "UserName",
		password :  "Password",
		signUp : "Sign Up",
		select: "Select Language"}
	this.userProfileStrings = {
			user : "User",
			role : "Role",
			list : "List of all cars and their owners",
			search : "Search",
			searchCars : "Search Cars",
			logOut : "Log Out",
			car: "Cars",
			addCar : "Add Car",
			stats : "Statistics",
			editUsers : "Edit Users"
	}
	this.signUpStrings = {
		back : "Back",
		form : "User Form",
		formSubtitle : "Please fill all texts in the fields",
		name: "First Name",
		lastName : "Last Name",
		mobile : "Mobile",
		ssid : "SSID",
		email : "email"

	}
	this.carsStrings = {
		id : "ID Number",
		brand : "Car Brand",
		model : "Car Model",
		engine : "Engine Power",
		lastService : "Last Service",
		fuel : "Fuel Consumption",
		delete : "Delete Car",
		edit : "Edit Car",
		km : "Kilometers passed today",
		add : "Add",
		kms : "Kilometers",
		service : "Service Required"
	}	
	this.otherStrings = {
		uniqueId : "Unique ID",
		kmsls : "Kilometers passed since last service",
		deleteUser : "Delete User",
		makeAdmin : "Make this user admin",
		report : "User Report",
		owner : "Owner",
		seeOwner : "See the owner",
		doc : "Car Documentation",
		results : "Search Results"

	}	
	this.signInUser = {
		username : "acestan",
		password : "122345"}
	this.carToAdd = {
		id : "",
		brand : "Opel",
		model : "Corsa",
		engine : "75",
		lastService : "2015-12-12",
		fuelCompsumption : "4.9",
		km : "0",
		fk:  vm.user.ssid}
	


	this.selectLanguage = function(language){


			var req = {
				method: 'POST',
				url: 'http://localhost:9090/Test/initConfigSignIn',
				headers: {
					'Content-Type': 'application/json;charset=utf-8'
					
				},
				data:  language
			}
				if(language === "mkd"){
					vm.macedonian = true;
					vm.english = false;
				}
			    else{
					vm.macedonian = false;
					vm.english = true;	
				}
			$http(req).then(function successCallback(response){
				console.log(response);
				
				// WELCOME PAGE STRINGS
				vm.signInStrings.title = response.data.signInStrings[0].substring(1,response.data.signInStrings[0].length-1,response.data.signInStrings[0])
				vm.signInStrings.signIn = response.data.signInStrings[1].substring(1,response.data.signInStrings[1].length-1,response.data.signInStrings[1])
				vm.signInStrings.subtitle = response.data.signInStrings[2].substring(1,response.data.signInStrings[2].length-1,response.data.signInStrings[2])
				vm.signInStrings.username = response.data.signInStrings[3].substring(1,response.data.signInStrings[3].length-1,response.data.signInStrings[3])
				vm.signInStrings.password = response.data.signInStrings[4].substring(1,response.data.signInStrings[4].length-1,response.data.signInStrings[4])
				vm.signInStrings.signUp = response.data.signInStrings[5].substring(1,response.data.signInStrings[5].length-1,response.data.signInStrings[5])
				vm.signInStrings.select = response.data.signInStrings[6].substring(1,response.data.signInStrings[6].length-1,response.data.signInStrings[6])
				
				 // USER PROFILE STRINGS
				vm.userProfileStrings.user = response.data.signInStrings[7].substring(1,response.data.signInStrings[7].length-1,response.data.signInStrings[7])
				vm.userProfileStrings.role = response.data.signInStrings[8].substring(1,response.data.signInStrings[8].length-1,response.data.signInStrings[8])	
				vm.userProfileStrings.list = response.data.signInStrings[9].substring(1,response.data.signInStrings[9].length-1,response.data.signInStrings[9])	
				vm.userProfileStrings.search = response.data.signInStrings[10].substring(1,response.data.signInStrings[10].length-1,response.data.signInStrings[10])
				vm.userProfileStrings.searchCars = response.data.signInStrings[11].substring(1,response.data.signInStrings[11].length-1,response.data.signInStrings[11])
				vm.userProfileStrings.logOut = response.data.signInStrings[12].substring(1,response.data.signInStrings[12].length-1,response.data.signInStrings[12])
				vm.userProfileStrings.car = response.data.signInStrings[13].substring(1,response.data.signInStrings[13].length-1,response.data.signInStrings[13])	
				vm.userProfileStrings.addCar = response.data.signInStrings[14].substring(1,response.data.signInStrings[14].length-1,response.data.signInStrings[14])	
				vm.userProfileStrings.stats = response.data.signInStrings[15].substring(1,response.data.signInStrings[15].length-1,response.data.signInStrings[15])
				vm.userProfileStrings.editUsers = response.data.signInStrings[16].substring(1,response.data.signInStrings[16].length-1,response.data.signInStrings[16])	
				
				//SIGN UP STRINGS
				vm.signUpStrings.back = response.data.signInStrings[17].substring(1,response.data.signInStrings[17].length-1,response.data.signInStrings[17])
				vm.signUpStrings.form = response.data.signInStrings[18].substring(1,response.data.signInStrings[18].length-1,response.data.signInStrings[18])	
				vm.signUpStrings.formSubtitle = response.data.signInStrings[19].substring(1,response.data.signInStrings[19].length-1,response.data.signInStrings[19])	
				vm.signUpStrings.name = response.data.signInStrings[20].substring(1,response.data.signInStrings[20].length-1,response.data.signInStrings[20])	
				vm.signUpStrings.lastName = response.data.signInStrings[21].substring(1,response.data.signInStrings[21].length-1,response.data.signInStrings[21])	
				vm.signUpStrings.mobile = response.data.signInStrings[22].substring(1,response.data.signInStrings[22].length-1,response.data.signInStrings[22])	
				vm.signUpStrings.ssid = response.data.signInStrings[23].substring(1,response.data.signInStrings[23].length-1,response.data.signInStrings[23])	
				vm.signUpStrings.email = response.data.signInStrings[24].substring(1,response.data.signInStrings[24].length-1,response.data.signInStrings[24])	

				//CARS STRINGS
				vm.carsStrings.id = response.data.signInStrings[25].substring(1,response.data.signInStrings[25].length-1,response.data.signInStrings[25])
				vm.carsStrings.brand = response.data.signInStrings[26].substring(1,response.data.signInStrings[26].length-1,response.data.signInStrings[26])	
				vm.carsStrings.model = response.data.signInStrings[27].substring(1,response.data.signInStrings[27].length-1,response.data.signInStrings[27])	
				vm.carsStrings.engine = response.data.signInStrings[28].substring(1,response.data.signInStrings[28].length-1,response.data.signInStrings[28])	
				vm.carsStrings.lastService = response.data.signInStrings[29].substring(1,response.data.signInStrings[29].length-1,response.data.signInStrings[29])	
				vm.carsStrings.fuel = response.data.signInStrings[30].substring(1,response.data.signInStrings[30].length-1,response.data.signInStrings[30])	
				vm.carsStrings.delete = response.data.signInStrings[31].substring(1,response.data.signInStrings[31].length-1,response.data.signInStrings[31])	
				vm.carsStrings.edit = response.data.signInStrings[32].substring(1,response.data.signInStrings[32].length-1,response.data.signInStrings[32])	
				vm.carsStrings.km = response.data.signInStrings[33].substring(1,response.data.signInStrings[33].length-1,response.data.signInStrings[33])	
				vm.carsStrings.add = response.data.signInStrings[34].substring(1,response.data.signInStrings[34].length-1,response.data.signInStrings[34])	
				vm.carsStrings.kms = response.data.signInStrings[35].substring(1,response.data.signInStrings[35].length-1,response.data.signInStrings[35])		
				vm.carsStrings.service = response.data.signInStrings[36].substring(1,response.data.signInStrings[36].length-1,response.data.signInStrings[36])	

				//OTHER STRINGS
				vm.otherStrings.uniqueId = response.data.signInStrings[37].substring(1,response.data.signInStrings[36].length-1,response.data.signInStrings[37])
				vm.otherStrings.kmsls = response.data.signInStrings[38].substring(1,response.data.signInStrings[37].length-1,response.data.signInStrings[38])
				vm.otherStrings.deleteUser = response.data.signInStrings[39].substring(1,response.data.signInStrings[38].length-1,response.data.signInStrings[39])
				vm.otherStrings.makeAdmin = response.data.signInStrings[40].substring(1,response.data.signInStrings[39].length-1,response.data.signInStrings[40])
				vm.otherStrings.report = response.data.signInStrings[41].substring(1,response.data.signInStrings[40].length-1,response.data.signInStrings[41])
				vm.otherStrings.owner = response.data.signInStrings[42].substring(1,response.data.signInStrings[41].length-1,response.data.signInStrings[42])
				vm.otherStrings.seeOwner = response.data.signInStrings[43].substring(1,response.data.signInStrings[42].length-1,response.data.signInStrings[43])
				vm.otherStrings.doc = response.data.signInStrings[44].substring(1,response.data.signInStrings[43].length-1,response.data.signInStrings[44])
				vm.otherStrings.results = response.data.signInStrings[45].substring(1,response.data.signInStrings[44].length-1,response.data.signInStrings[45])
														
			},function errorCallback(response){
				if(vm.macedonian ===  true){
					$translate.use('mk');
				}
				if(vm.english === true){
					$translate.use('en');
				}	
				$translate(['title','signIn','subtitle','username','password','signUp','select']).then(function(result){
					vm.signInStrings.title = result.title;
					vm.signInStrings.signIn = result.signIn;
					vm.signInStrings.subtitle = result.subtitle;
					vm.signInStrings.username = result.username;
					vm.signInStrings.password = result.password;
					vm.signInStrings.signUp = result.signUp;
					vm.signInStrings.select = result.select;


				})
			})}
	this.userProfileStrings = function(){
		var data;
		var strings={};
		if(vm.english === true){ data = "english"}
		if(vm.macedonian === true){data = "mkd"}
		var req = {
				method: 'POST',
				url: 'http://localhost:9090/Test/initConfigSignIn',
				headers: {
					'Content-Type': 'application/json;charset=utf-8'
					
				},
				data:  data
			}

	}
	this.onSignUpClicked = function(){
		authService.signUpFunction(this.user).then(function(resultSU){
			if(resultSU.status === "failure")
			{
				$.jGrowl.defaults.animateOpen = {
									width: 'show'
								};
								$.jGrowl.defaults.animateClose = {
									width: 'hide'
								};

								$.jGrowl("Failed  to sign up ! Reason : The "+resultSU.reason+" is not unique !");
				
			}
			else
			{

				$.jGrowl.defaults.animateOpen = {
									width: 'show'
								};
								$.jGrowl.defaults.animateClose = {
									width: 'hide'
								};

								$.jGrowl("Successfull sign up, welcome  !");
				
				$location.path("/profile");
			}
			//console.log(resultSU);
		})}
	this.onSignInClicked = function(){
		//console.log("Rezultat vo app.js");
		vm.clickedSignIn = true;
		authService.signInFunction(this.signInUser).then(function(resultSI){
			if(resultSI.status === "failure")
			{

								$.jGrowl.defaults.animateOpen = {
									width: 'show'
								};
								$.jGrowl.defaults.animateClose = {
									width: 'hide'
								};

								$.jGrowl("Failed  to sign in ! Reason : The "+resultSI.reason+" is not unique !");
				
				
			}
			else
			{
				vm.showWelcome = false;
				vm.showCars = true;
				vm.user = resultSI.data;
				$location.path("profile");
			}

		});
			}	
	this.logOut = function(){
	$location.path('/');
	this.showEditUsers = false;
	this.showWelcome = true;
	this.showSignUp = false;
	this.showSignIn = false;
	this.showProfile = false;
	this.showCars = false;
	this.showAddCar = false;
	this.showStats = false;
	this.showResults = false;
	this.sear = "";
	this.user = {
		name : "Aleksandar",
		lastName : "Stanoevski",
		mobile : "070 000 000",
		email : "acestan@gmail.com",
		username : "acestan",
		password : "122345",
		ssid : "2208993111111",
		role : "",
		cars : []

	}
	this.signInUser = {
		username : "acestan",
		password : "122345"
	}
	this.carToAdd = {
		id : "",
		brand : "Opel",
		model : "Corsa",
		engine : "75",
		lastService : "2015-12-12",
		fuelCompsumption : "4.9",
		km : "0",
		fk:  vm.user.ssid
	}}
	this.editUsers =function(){
		this.showEditUsers = true;
		this.showStats = false;
		this.showCars = false;
		this.showAddCar =false;
		this.showResults = false;}
	this.onClickSignUp = function(){ 
		this.showSignUp = true;
		this.showWelcome = false;
		$location.path('/signup');};
	this.onClickSignIn = function(){ 
		this.showSignIn = true;
		this.showWelcome = false;
		$location.path('/signin');};
	this.onCarsClicked = function(){
				this.showEditUsers = false;
				this.showAddCar = false;
				this.showCars = true;
				this.showStats = false;this.showResults = false;}
	this.onStatsClicked = function(){
				this.showEditUsers = false;
				this.showStats = true;
				this.showCars = false;
				this.showAddCar =false;
				this.showResults = false;}
	this.onMngCarsClicked = function(){
				console.log(vm.carToAdd);
				this.showAddCar = true;
				this.showEditUsers = false;
				this.showCars = false;
				this.showStats = false;
				this.showResults = false;}
	this.BackClicked = function(){
				$location.path('/');
				this.showWelcome = true;
				this.showSignUp = false;
				this.showSignIn = false;
				this.showProfile = false;
				this.showCars = false;
				this.showAddCar = false;
				this.showStats = false;}
	this.carBack = function(){
					console.log(vm.user.cars);
					$location.path('/profile');}
	this.editCar = function(car){
				vm.carToAdd = car;
				$location.path('/edit');}
	this.addCar =  function(){
		carService.addCar(vm.carToAdd).then(function(addResult){
			if(addResult.status === "success")
			{
				vm.user.cars.push(vm.carToAdd);
				vm.showCars = true;
				vm.showAddCar = false;
				$location.path("/profile");
				$.jGrowl.defaults.animateOpen = {
					width: 'show'
				};
				$.jGrowl.defaults.animateClose = {
					width: 'hide'
				};

				$.jGrowl("Successfully added car!");
				vm.carToAdd = {
								id : "",
								brand : "Opel",
								model : "Corsa",
								engine : "75",
								lastService : "2015-12-12",
								fuelCompsumption : "4.9",
								fk:  vm.user.ssid}
			}
			else
			{
				
				$.jGrowl.defaults.animateOpen = {
					width: 'show'
				};
				$.jGrowl.defaults.animateClose = {
					width: 'hide'
				};

				$.jGrowl("Failed to add car!");
			}

		})}
	this.deleteCar = function(car){
		carService.deleteCar(car).then(function(deleteResult){
			console.log(deleteResult);
			if(deleteResult.status === "success")
			{
				vm.user.cars.splice(vm.user.cars.indexOf(car),1);
				$location.path("/profile");
			}
		})}
	this.updateCarInfo = function(car){
		carService.updateCarInfo(car).then(function(updateResult){
			if(updateResult.status === "success"){
				vm.carToAdd = {
								id : "",
								brand : "Opel",
								model : "Corsa",
								engine : "75",
								lastService : "2015-12-12",
								fuelCompsumption : "4.9",
								fk:  vm.user.ssid
							}
							vm.showCars = true;
							$location.path("/profile");
			}
			else{
				alert("Unsccessfull update !");
			}
			console.log(updateResult)
		})}
	this.addTrip = function(car){
				vm.carToAdd = car;
				console.log(vm.CarToAdd);
				$http.post("http://localhost:9090/Test/updateTrip",vm.carToAdd).then(

					function(response){
						if(response.data.okSSID == true){
							console.log(response.data);
							vm.carToAdd = {
								id : "",
								brand : "Opel",
								model : "Corsa",
								engine : "75",
								lastService : "2015-12-12",
								fuelCompsumption : "4.9",
								km : "0",
								fk:  vm.user.ssid
							}
							this.showCars = true;

							$location.path("/profile");
							$.jGrowl.defaults.animateOpen = {
								width: 'show'
							};
							$.jGrowl.defaults.animateClose = {
								width: 'hide'
							};

							$.jGrowl("Successfull update!");

						}
						else{
							$.jGrowl.defaults.animateOpen = {
								width: 'show'
							};
							$.jGrowl.defaults.animateClose = {
								width: 'hide'
							};

							$.jGrowl("Unsccessfull update");
						}
					},
					function(error){

					})}
	this.searchCars = function(){
		this.showResults = true;
		this.showCars = false;
		this.showStats = false;
		this.showAddCar = false;
		this.showEditUsers = false;

		$http.post("http://localhost:9090/Test/search",vm.searchContent).then(

			function(response){
				console.log(response);
				vm.searchResult = response.data;
			}
			)}
	this.adminDeleteCar = function(car){

				if(confirm("Are you sure you want to delete this car ?") == true){
					$http.post("http://localhost:9090/Test/deleteCar",car).then(
						function(response){
							if(response.data.okSSID == true){
								console.log(response.data);
								vm.user.cars.splice(vm.searchResult.indexOf(car),1);
								vm.showResults = false;
								$.jGrowl.defaults.animateOpen = {
									width: 'show'
								};
								$.jGrowl.defaults.animateClose = {
									width: 'hide'
								};

								$.jGrowl("Successfull delete!");
								$location.path("/profile");
							}
							else{
								$.jGrowl.defaults.animateOpen = {
									width: 'show'
								};
								$.jGrowl.defaults.animateClose = {
									width: 'hide'
								};

								$.jGrowl("Unsccessfull delete!");
							}
						},
						function(error){

						})
				}}		
}]);
app.config(function($routeProvider) {
	$routeProvider.when('/signup',
	{
		templateUrl: 'templates/pages/signup/index.html'
	})
	
.when('/profile',
{
	templateUrl: 'templates/pages/userprofile/index.html'
})
.when('/cars',
{
	templateUrl: 'templates/pages/cars/index.html'
})
.when('/mngcars',
{
	templateUrl: 'templates/pages/mngcars/index.html'
})
.when('/stats',
{
	templateUrl: 'templates/pages/stats/index.html'
})
.when('/edit',
{
	templateUrl:'templates/pages/edit/index.html'
})
.otherwise({redirectTo : '/'})	
}
);

app.config(function ($translateProvider) {
	$translateProvider.translations('en',{
		title : "Welcome",
		signIn : "Sign In",
		subtitle :  "Enter your User Name and Password",
		username : "UserName",
		password :  "Password",
		signUp : "Sign Up",
		select: "Select Language"
	});
	$translateProvider.translations('mk',{
		title : "Добредојдовте",
		signIn : "Најавете се",
		subtitle :  "Внесете го вашето корисничко име и лозинка",
		username : "Корисничко име",
		password :  "Лозинка",
		signUp : "Пријавете се",
		select: "Изберете јазик"
	});
	$translateProvider.preferredLanguage('en');
});

