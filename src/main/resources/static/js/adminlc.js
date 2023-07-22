function saveCredentials() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    const users = [username, password];
    localStorage.setItem("username, password", users);
   // localStorage.setItem("password", password);
  //alert("Credentials saved to localStorage!");
}

function removeCredentials(){
//	 var username = document.getElementById("username").value;
//    var password = document.getElementById("password").value;
 //   const users = [username, password];
  console.log("remove = username, password");
	localStorage.removeItem("username, password");
    alert("Credentials removed from localStorage!");
}

function clearaaLS(){
	localStorage.clear();
}

function addCart() {
  var id = document.getElementById("id").value;
  var item_title = document.getElementById("item_title").value;
  var price = document.getElementById("price").value;
  var quantity = document.getElementById("quantity").value;
  var image_Filename = document.getElementById("image_Filename").value;
  var product = {
    id: id,
    item_title: item_title,
    price: price,
    quantity: quantity,
    image_Filename: image_Filename
  };
  
 // console.log(image_Filename+"iamge file name");
  //alert(image_Filename+"iamge file name");

  // Retrieve existing data from local storage
  var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];

  // Push the new product to the array
  cartItems.push(product);

  // Store the updated array back to local storage
  localStorage.setItem("cartItems", JSON.stringify(cartItems));

 // console.log("JSON.stringify======="+JSON.stringify(cartItems));

  //alert("hello");
  }

function removeCartItem() {
  var id = document.getElementById("id").value;
  alert("Remove function is running " + id);
  console.log(id);

  var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];

  for (var i = 0; i < cartItems.length; i++) {
    if (id == cartItems[i].id) {
      cartItems.splice(i, 1);
      break;
    }
  }

  localStorage.setItem("cartItems", JSON.stringify(cartItems));

  $(document).ready(function() {
    // Additional logic here if needed
  });
}



var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
for(const x of cartItems){
	
document.getElementById("demo").innerHTML =  x1;
x1 = Object.values(x);
//console.log(x);
//alert("Running");
}
/* function removeCredentials() {
  // Make an AJAX request to the server
  var xhr = new XMLHttpRequest();
  xhr.open('POST', '/logoutadmin');
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onload = function() {
    if (xhr.status === 200) {
      // Remove the credentials from localStorage
      localStorage.removeItem("username");
      localStorage.removeItem("password");
      alert("Credentials removed successfully!");
    } else {
      alert("Failed to remove credentials!");
    }
  };
  xhr.send();
} */


/* function addCart(){
	var id = document.getElementById("id").value;
	var item_title = document.getElementById("item_title").value;
	var price = document.getElementById("price").value;
	var quantity = document.getElementById("quantity").value
	alert(id, item_title +"working"+ price + quantity);
	const product = [id,item_title,price,quantity];
	localStorage.setItem("id,item_title,price,quantity", product);
	console.log(product);
	//this.http.post("http://localhost:8080//userviewproduct/addcart/"+id)
}  */