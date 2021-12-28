/**
 * 
 */

$(function(){        
         
            $('.reviewArea').click(function(){
             	
            	$('#reviewClickpopUp').fadeIn();
                $('#allScreen').fadeIn();
                
                var legendText = $(this).children('#legendText').html();
                var cleanText = $(this).children().children('#cleanText').html();
                var areaText = $(this).children().children('#areaText').html();
                var contentText = $(this).children().children('#contentText').html();
                
              
                
                $('#popupName').html(legendText);
                $('#popupCleanType').html(cleanText);
                $('#popupArea').html(areaText);
                $('#popupContent').html(contentText);
         });
            $('#closeBtn').click(function(){
             $('#reviewClickpopUp').fadeOut();
                $('#allScreen').fadeOut();
         });
          
            
        });