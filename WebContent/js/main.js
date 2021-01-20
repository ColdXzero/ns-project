"use strict";
jQuery(document).ready(function ($) {

//==========================================
// MOBAILE MENU
//=========================================

    $('#navbar-menu').find('a[href*="#"]:not([href="#"])').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: (target.offset().top - 0)
                }, 1000);
                if ($('.navbar-toggle').css('display') != 'none') {
                    $(this).parents('.container').find(".navbar-toggle").trigger("click");
                }
                return false;
            }
        }
    });


//==========================================
//ScrollUp
//=========================================

    $(window).scroll(function () {
        if ($(this).scrollTop() > 600) {
            $('#scrollUp').fadeIn('slow');
        } else {
            $('#scrollUp]').fadeOut('slow');
        }
    });

    $('#scrollUp').click(function () {
        $("html, body").animate({scrollTop: 0}, 1000);
        return false;
    });



//==========================================
// For fancybox active
//=========================================

    $('.fancybox').fancybox();
    
    

//==========================================
// Loading
//=========================================

    $(window).load(function () {
        $("#loading").fadeOut(500);
    });

  //============== ajax  change contacts
  
    
  
    
    
    $("#signform").submit(function (event){
    	
 if(!validateSignup($("#hid1").attr("value"))){event.preventDefault();}
    });

});

function ShowTempPop() {
	  var popup = document.getElementById("TempPop");
	  popup.classList.toggle("show");
	}
function ShowAll() {
	  var popup = document.getElementById("alluser");
	  popup.classList.toggle("show");
	}
function ShowAll2(id) {
	  var popup = document.getElementById("alluser"+id);
	  popup.classList.toggle("show");
	}
function ShowTempPop2(id) {
	  var popup = document.getElementById("TempPop"+id);
	  popup.classList.toggle("show");
	}
function ShowTempPop3(id) {
	  var popup = document.getElementById("TempPopSend"+id);
	  popup.classList.toggle("show");
	}


function ShowFieldPop() {
	$("#not_field_add").val("");
	  var popup = document.getElementById("FieldsPop");
	  popup.classList.toggle("show");
	}
function ShowFieldPop2(id) {
	
	$("#not_field_add"+id).val("");
	  var popup = document.getElementById("FieldsPop"+id);
	  popup.classList.toggle("show");
	}
function ShowPop() {
	  var popup = document.getElementById("myPopup");
	  popup.classList.toggle("show");
	}
function hide2() {
	  $("#myPopup2").hide();
	}
function ShowPop2() {
	  var popup = document.getElementById("myPopup2");
	  popup.classList.toggle("show");
	}
function validateSignup(val)
{
	
	if(val=="signup"){
	var err=0;
	
		if($("#usr_name_2").val().length==0){
			$("#err_usr_name2 > h6").html("User name is required column!");
		err++;
			$("#err_usr_name2").css("display","inline");}
		
		if($("#su_email").val().length==0){
			$("#error_mail > h6").html("Email is required column!");
			$("#error_mail").css("display","inline");

			err++;
	}
		else if($("#su_email").val()!=$("#su_email_con").val()) {
		$("#error_mail > h6").html("Emails don't match!");
		err++;	
		$("#error_mail").css("display","inline");}
	else if($("#su_email").val()==$("#su_email_con").val()) {$("#error_mail").css("display","none");}

	if($("#in_pwd").val().length==0){
	$("#error_pwd > h6").html("Password is required column!");
	err++;
	$("#error_pwd").css("display","inline");
	}
	else if($("#in_pwd").val()!=$("#con_pwd").val()) {
		$("#error_pwd > h6").html("Passwords don't match!");
		err++;
		$("#error_pwd").css("display","inline");
	}
	else if($("#in_pwd").val()==$("#con_pwd").val()) {$("#error_pwd").css("display","none");}
	
	if(err>0) {  return false;}
	else {return true;}}
	
else if(val=="signin"){
	var err2=0;
	if($("#usr_name").val().length==0){
		$("#err_usr_name > h6").html("User name is required column!");
		$("#err_usr_name").css("display","inline");
	err2++;	
	}
	
	if($("#pwd1").val().length==0){
		$("#err_pwd > h6").html("Password is required column!");
		err2++;
		$("#err_pwd").css("display","inline");}
		
	
	if(err2>0) { return false;}
	else {return true;}
	}
	}

function clickAddContact()
{
	var order =$("#contact_order_new").val();
	var con_sta =$("#contact_status_new").val();
	var con_val =$("#contact_val_new").val();
	var con_type =$("#contact_type_new").val();

	$.post("ContactRequestAdd",{con_type_new:con_type,con_val_new:con_val,con_order_new:order,con_status_new:con_sta},function (result){
	alert(result);
	});

}
function clickchange(){
	var id =$("#hid_order_id").val();
	var order =$("#v_order"+id).val();
	var con_sta =$("#contact_status"+id).val();
	
	$.post("ContactsRequest",{con_id:id,con_status:con_sta,con_order:order},function (result){
		$("#myPopup2").html(result);
		ShowPop2();
	});
}

function addFieldNameFun()
{ 
	var d=$("#fieldsnew").val();
	
	$("#fieldsnew").val($("#fieldsnew").val()+"#"+$("#not_field_add").val());
	$("#not_txt").val($("#not_txt").val()+" #"+$("#not_field_add").val()+"#");
	var popup = document.getElementById("FieldsPop");
	  popup.classList.toggle("show");
	  
	  $("#not_txt").focus();

}

function addFieldNameFun2(id)
{ 
	var d=$("#fieldsnew"+id).val();
	
	$("#fieldsnew"+id).val($("#fieldsnew"+id).val()+"#"+$("#not_field_add"+id).val());
	$("#not_txt"+id).val($("#not_txt"+id).val()+" #"+$("#not_field_add"+id).val()+"#");
	var popup = document.getElementById("FieldsPop"+id);
	  popup.classList.toggle("show");
	  
	  $("#not_txt"+id).focus();

}