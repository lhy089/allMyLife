$(document).ready(function(){
   var formInputs = $('input[type="text"],input[type="password"]');
   formInputs.focus(function() {
       $(this).parent().children('p.join-label').addClass('formTop');
   });
   
   formInputs.focusout(function() {
      if ($.trim($(this).val()).length == 0){
      $(this).parent().children('p.join-label').removeClass('formTop');
      }
   });
   
});