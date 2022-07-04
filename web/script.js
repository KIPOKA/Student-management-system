/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var myText = document.getElementById("myText");
var result= document.getElementById("result");
var limit = 250;
result.textContent= 0 + "/" +limit;

myText.addEventListener("input", function(){
    var textLength = myText.value.length;
    console.log(textLength);
    result.textContent = textLength + "/"+limit;
    if (textLength > limit) {
        myText.style.borderColor = "#ff2851";
        result.style.color = "#ff2851";
       }
       else{
           myText.style.borderColor = "#b2b2b2";
           result.style.color = "#737373";
       }
});

