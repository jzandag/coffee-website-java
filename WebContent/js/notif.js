

$(document).ready(function(){
	function checkNotif(){
		$.ajax({
			url: baseUrl+"/notifList?id="+$('#idId').text(),
			data:{},
			success:function(data){
				var result = JSON.parse(data);
				
				var row = "";
				if(result.content.length > 0) {
					for(var i in result.content){
						row += "<a href=\"#\">"+result.content[i].description+"</a>";
					}
					$('#myDropdown').empty();
	    			$('#myDropdown').append(row);
				}
				else{
					$('#myDropdown').empty();
	    			$('#myDropdown').append('<a href=#s>No notifications</a>');
				}
				if(result.totalRecords == 0)
					$('.badge-light').html('');
				else
					$('.badge-light').html(result.totalRecords);
				
			},
	        error:function(dat){
	            //alert(dat.queue_list);
	            
	        }
		});
	}
	checkNotif();
	$('.dropbtn').click(function(event){
		console.log($('#idId').text());
		$.ajax({
    		url: baseUrl+"/notifList?id="+$('#idId').text(),
    		data:{},
    		success:function(data){
    			var result = JSON.parse(data);
    			
    			var row = "";
    			if(result.content.length > 0) {
    				for(var i in result.content){
    					row += "<a href=\"#\">"+result.content[i].description+"</a>";
    				}
    				$('#myDropdown').empty();
        			$('#myDropdown').append(row);
    			}
    			else{
    				$('#myDropdown').empty();
        			$('#myDropdown').append('<a href=#s>No notifications</a>');
    			}
    			if(result.totalRecords == 0)
    				$('badge-light').html();
    			else
    				$('badge-light').html(result.totalRecords);
    			
    		},
            error:function(dat){
                //alert(dat.queue_list);
                
            }
    	});
		
		$.ajax({
    		url: baseUrl+"/clearNotif?id="+$('#idId').text(),
    		data:{},
    		success:function(data){
    			var result = JSON.parse(data);
    			
    		},
            error:function(dat){
                //alert(dat.queue_list);
                
            }
    	});
		$.ajax({
    		url: baseUrl+"/notifList?id="+$('#idId').text(),
    		data:{},
    		success:function(data){
    			
    			if(result.totalRecords == 0)
    				$('badge-light').html();
    			else
    				$('badge-light').html(result.totalRecords);
    			
    		},
            error:function(dat){
                //alert(dat.queue_list);
                
            }
    	});
	});
	
	$('.dropbtn').click(function(e){
		$('#myDropdown').toggle();
	});
	
});