function treatment_X(){
    var x=document.coor_form.coor_x;
    var count=0;
    for(var i=0; i<x.length;i++){
        if(x[i].checked){
            count+=1;
        }
    }
    if(count!=1){
        return false;
    }
    else{

        return true;
    }
}


function treatment_Y(){
    var y=document.coor_form.coor_y.value;
    var regexp = new RegExp("^-?[0-9]+([.,]?[0-9]+)?$");
    if(regexp.test(y)){
        let val = y.replace(",",".");
        if(val>=-3 && val<=3){
            return true;
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
}


function treatment_R(){
    var r=document.coor_form.value_R;
    var count2=0;
    for(var i=0; i<r.length;i++){
        if(r[i].checked){
            count2+=1;
        }
    }
    if(count2!=1){
        return false;
    }
    else{

        return true;
    }
}

function errorMessage(){
    var er_x = document.getElementById('error_x');
    var er_y = document.getElementById('error_y');
    var er_r = document.getElementById('error_r');
    er_x.innerHTML="";
    er_y.innerHTML="";
    er_r.innerHTML="";
    er_x.style.marginBottom = "0px";
    er_y.style.marginBottom = "0px";
    er_r.style.marginBottom = "0px";
    if (!treatment_X()) {
        er_x.style.marginBottom = "-15px";
        er_x.innerHTML="Choose only one X!";}
    if (!treatment_Y()) {
        er_y.style.marginBottom = "-15px";
        er_y.innerHTML="Wrong Y!";}
    if (!treatment_R()) {
        er_r.style.marginBottom = "-15px";
        er_r.innerHTML="Choose only one R!";}
}

function addResult(result){
    var position = document.getElementsByClassName('result')[0];
    var new_line = document.createElement('tr');

    position.appendChild(new_line);

    var x = document.createElement('td');
    x.innerHTML=result['x'];
    new_line.appendChild(x);

    var y = document.createElement('td');
    y.innerHTML=result['y'];
    new_line.appendChild(y);

    var r = document.createElement('td');
    r.innerHTML=result['r'];
    new_line.appendChild(r);

    var tm = document.createElement('td');
    tm.innerHTML=result['tm'];
    new_line.appendChild(tm);

    var tml = document.createElement('td');
    tml.innerHTML=result['tml'];
    new_line.appendChild(tml);

    var res = document.createElement('td');
    res.innerHTML=result['res'];
    new_line.appendChild(res);


}

function getTable(){
    $.post('get_table.php', function(data){
        var result = JSON.parse(data);
        for(let i=0;i<result.length;i++){
            addResult(result[i]);
        }
    })
}

function sendForm(){
    var details = $('form').serialize();
    $.get('controller', details, function(data){
        window.location.reload();
    })
}

function checkCoord(e){
    e.preventDefault();
    errorMessage();
    if(treatment_X() && treatment_Y() && treatment_R()){
        sendForm();
    }
}

//getTable();

var sendButton = document.getElementById('button');
sendButton.addEventListener("click", checkCoord);
