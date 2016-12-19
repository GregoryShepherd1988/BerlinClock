function loadClockData() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == XMLHttpRequest.DONE) {
            if (xmlhttp.status == 200) {
                displayClock(xmlhttp.responseText);
            }
            else if (xmlhttp.status == 400) {
                alert('There was an error 400');
            }
            else {
                alert('something else other than 200 was returned');
            }
        }
    };

    xmlhttp.open("GET", "/clock", true);
    xmlhttp.send();
}

function setLightArray(id, up) {
    for (var i = 0; i < up.length; i++) {
        setLight(id + "_" + i, up[i]);
    }
}

function setLight(id, up){
    var element = document.getElementById(id);
    if(up) {
        if(!element.classList.contains('up')) {
            element.classList.add('up');
        }
    }else{
        if(element.classList.contains('up')) {
            element.classList.remove('up');
        }
    }
}

function displayClock(json){
    clockObj = JSON.parse(json);
    setLight("second", clockObj.second);

    setLightArray("hour_5", clockObj.hour_5);
    setLightArray("hour_1", clockObj.hour_1);

    setLightArray("minute_5", clockObj.minute_5);
    setLightArray("minute_1", clockObj.minute_1);
}

function startClock(){
    var clockwork = window.setInterval(function(){ loadClockData(); }, 1000);
}

loadClockData();
startClock();