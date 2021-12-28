/**
 * 
 */

const date = new Date();



        const renderCalendar = () => {
            date.setDate(1);


            const monthDays = document.querySelector(".days");

            const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

            const prevLastDay = new Date(date.getFullYear(), date.getMonth(), 0).getDate();

            const firstDayIndex = date.getDay();

            const lastDayIndex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();

            const nextDays = 7 - lastDayIndex - 1;


            const months = [
                "1월",
                "2월",
                "3월",
                "4월",
                "5월",
                "6월",
                "7월",
                "8월",
                "9월",
                "10월",
                "11월",
                "12월",
            ];

            document.querySelector(".date h1").innerHTML = months[date.getMonth()];


            document.querySelector(".date p").innerHTML = new Date().toDateString();

            let days = "";

            for (let x = firstDayIndex; x > 0; x--) {
                days += `<div class="prev-date">${prevLastDay-x+1}</div>`;
            }

            for (let i = 1; i <= lastDay; i++) {
                if (i === new Date().getDate() && date.getMonth() === new Date().getMonth()) {
                    days += `<div class="today">${i}</div>`;

                } else {
                    days += `<div>${i}</div>`;
                }
            }

            for (let j = 1; j <= nextDays; j++) {
                days += `<div class="next-date">${j}</div>`;
                monthDays.innerHTML = days;
            }
        }

        document.querySelector(".prev").
        addEventListener("click", () => {
            date.setMonth(date.getMonth() - 1);
            renderCalendar();
        });
        document.querySelector(".next").
        addEventListener("click", () => {
            date.setMonth(date.getMonth() + 1);
            renderCalendar();
        });

        renderCalendar();
 
        
        
        
        
        $('.days>div').click(function() {
			var day = $(this).html();
			var month = $('.date').children('h1').text();
			var month2 = month.substr(0,2);
			$('#reservationDay').html(month2 + "월" + day + "일 예약");
			console.log(month2);
			
			$.ajax({
				url : "/co/conditionSpan.do",
				type : "get",
				data : {"day":day, "month2":month2},
				dataType : "json",
				success : function(data){
					var $tableappend = $('#print');
					
					$.each(data,function(index,item){
						var str = 	"<tr>"+
									"<td>" + item.reqDate + "</td>" +
									"<td>" + item.userId + "</td>" +
									"</tr>"; 
									
								$tableappend.append(str);
						
					});
					
					
				},
				error : function(){
					console.log('ajax 통신에러');
				}
				
				
			});
		});
	