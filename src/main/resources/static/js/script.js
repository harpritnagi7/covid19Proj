console.log("this is script file")
$(document).ready(function () {
    $("#type").change(function () {
        var val = $(this).val();

 if (val == "NI") {
            $("#size").html("<option value='1'>NI: PGIMER Chandigarh</option><option value='2'>NI: FORTIS Amritsar</option><option value='3'>NI: FORTIS Mohali</option><option value='4'>NI: FORTIS Chandigarh</option><option value='5'>NI: AIIMS Bathinda</option><option value='6'>NI: AIIMS New Delhi</option><option value='7'>NI: AIIMS Bilaspur Himachal</option><option value='8'>NI: AIIMS Jodhpur</option><option value='9'>NI: Hospitals in Delhi</option> <option value='10'>NI: AIIMS Rishikesh</option><option value='11'>NI: AIIMS Vijaypur(J&K)</option><option value='12'>NI: AIIMS Manethi(Haryana)</option>");
        }


 else if (val == "WCI") {
            $("#size").html("<option value='1'>WCI: Appollo Hospital(Delhi)</option><option value='2'>WCI: AIIMS Bhopal</option><option value='3'>WCI: Apollo Hospital(Lucknow)</option><option value='4'>WCI: AIIMS Raebareli</option><option value='5'>WCI: AIIMS Gorakhpur</option><option value='6'>WCI: Hospitals in Ahmedabad</option><option value='7'>WCI: AIIMS Jodhpur</option><option value='8'>WCI: AIIMS Rishikesh</option><option value='9'>WCI: Appollo Hospital In Indore</option><option value='10'>WCI: Appollo Hospital in Lavasa</option><option value='11'>WCI: Appollo Hospital In Mumbai</option><option value='12'>WCI: Appollo Hospital in Hyderabad</option><option value='13'>WCI: AIIMS Madurai</option><option value='14'>WCI: AIIMS Darbhanga</option><option value='15'>WCI: AIIMS Deoghar</option><option value='16'>WCI: AIIMS Raikot</option><option value='17'>WCI: AIIMS Raipur</option><option value='18'>WCI: AIIMS Mangalagiri</option><option value='19'>WCI: AIIMS Kalyani</option><option value='20'>WCI: Appollo Hospital in Nashik</option>");
            } 


else if (val == "EI") {
            $("#size").html("<option value='1'>EI: FORTIS Anandpur Kolkata</option><option value='2'>EI: FORTIS Medical Center Kolkata</option><option value='3'>EI: AIIMS Guwahati</option><option value='4'>EI: Appollo Hospitals in Bilaspur Chattisgarh</option><option value='5'>EI: AIIMS Patna</option><option value='6'>EI: Hospitals In Guwahati</option><option value='7'>EI: Hospitals In Kolkata</option><option value='8'>EI: AIIMS Nagpur</option><option value='9'>EI: Hospitals In Karur</option><option value='10'>EI: Hospitals In Trichy</option><option value='11'>EI: Hospitals in Guwahati</option>");
           
             }
            
 else if (val == "SI") {
            $("#size").html("<option value='1'>SI: FORTIS Bannerghatta karnatka</option><option value='2'>SI: FORTIS Cunningham karnatka</option><option value='3'>SI: FORTIS Nagarbhavi Bengaluru</option><option value='4'>SI: FORTIS Rajajinagar Karnatka</option><option value='5'>SI: AIIMS Bhubaneswar</option><option value='6'>SI: Appollo Hospital In Visakhapatnam</option><option value='7'>SI: Appollo Hospital In Mysore</option><option value='8'>SI: Appollo Hospital In Mumbai</option><option value='9'>SI: Appollo Hospital In Kochi</option><option value='10'>SI: Appollo Hospital In Hyderabad</option><option value='11'>SI: Appollo Hospital In Chennai</option><option value='12'>SI: Appollo Hospital In Bhubaneshwar</option><option value='13'>SI: Appollo Hospital In Bangalore</option><option value='14'>SI: Appollo Hospital in Lavasa</option><option value='15'>SI: Appollo Hospital in Hyderabad</option><option value='16'>SI: Appollo Hospital in Mysore</option><option value='17'>SI: Appollo Hospital in Kochi</option><option value='18'>SI: AIIMS Bibinagar</option><option value='19'>SI: Appollo Hospital In Madurai</option><option value='20'>SI: Appollo Hospital In Nashik</option><option value='21'>SI: Appollo Hospital In Nellore</option><option value='22'>SI: Appollo Hospital In Aragonda</option><option value='23'>SI: Appollo Hospital In Kakinada</option>");
           
 			 }

        else if (val == "none") {
            $("#size").html("<option value=''>--Select nearest hospital--</option>");
        }
    });
});



setInterval(function() {
    var div = document.querySelector("#counter");
    var count = div.textContent * 1 - 1;
    div.textContent = count;
    if (count <= 0) {
        window.location.replace("http://localhost:8080/user/index");
    }
}, 1000);

