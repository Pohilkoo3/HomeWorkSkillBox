$(function(){
$.get('/tasks/',{}, function(response){
        if(response.length == 0){
           alert('Все cупер. Все дела переделаны!');
        }
        for(i in response)
        {
            let element = '<div class="task">' + response[i].id  + ' → '+ response[i].textTask + '</div>';
            $('.mapping-all-tasks').append(element);
        }
        });
$('.add-task').on('click', function()
    {
  let textTask = $('.add-text').val();
    $.post('/tasks/', {textTask: textTask}, function(response){
 if(response > 0){
        $('.add-text').val('');
        $('.all-tasks').html('У вас все получилось. Номер нового дела => ' + response);
        }
    });
});

 $('.getAllTasks').on('click', function()
    {
    $('.all-tasks').html('');
$.get('/tasks/',{}, function(response){
        if(response.length == 0){
           alert('Все cупер. Все дела переделаны!');
        }
        for(i in response)
        {
            let element = response[i].id  + " → "+ response[i].textTask + " ;\n ";
            $('.all-tasks').append(element);
        }
        });
    });

    $('.DeleteAllTasks').on('click', function()
        {
       $.ajax({
           method: "DELETE",
           url: "/tasks/",
           success: true
       });
       $('.all-tasks').html('Прекрасно, все дела сделаны.');
    });

});

