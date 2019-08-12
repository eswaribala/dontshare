/**
 * 
 */


window.addEventListener('load',function()
		{

			//create ajax object

			ajaxObject=null;
			try
			{
				ajaxObject=new XMLHttpRequest();
			}
			catch(e)
			{
				try
				{
					ajaxObject=new ActiveXObject("Msxml2.XMLHTTP3.0");
				}
				catch(e)
				{
					console.log("Ajax object not supported in the browser");
				}

			}

			document.querySelector("form").addEventListener('submit', function()
			{

				 var mobileNo=document.querySelector("#mobileNo").value;
				 var name=document.querySelector("#name").value;
				 //json object
				 var userObj={
				 	"mobileNo":mobileNo,
				 	"name":name
				 }

                 user=JSON.stringify(userObj);

				//opening server side url
				ajaxObject.open("post", "http://localhost:6060/adduser", true);
				ajaxObject.setRequestHeader("Content-Type","application/json");
				ajaxObject.send(user);

				/*//send parameters
				ajaxObject.send("RegNo="+regNo+"&Maker="+maker+"&RegDate="+regDate+
					"&ChassisNo="+chassisNo+"&EngineNo="+engineNo+
					"&FuelType="+fuelType+"&Color="+color);*/


				//check state change
				ajaxObject.onreadystatechange=function()
				{
					if((ajaxObject.readyState==4)&&(ajaxObject.status==200))
					{
						console.log(ajaxObject.responseText);
						var data=JSON.parse(ajaxObject.responseText);
						console.log(data);
						/*elem=document.createElement("h4");
						textNode=document.createTextNode(data.mobileNo+","+data.name);
						elem.appendChild(textNode);
						document.querySelector("section").appendChild(elem);*/

					}
				}
           return false;
			});
		})


























