var ws = null;
var url = "ws://localhost:8080/echo";

function setConnected(connected){
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('echo').disabled = !connected;
}

function connect(){
    ws = new WebSocket(url);

    ws.onopen = function(){
        setConnected(true);
        log('Info: Opening connection.')
    };

    ws.onmessage = function(event){
        log(event.data);
    };

    ws.onclose = function(){
        setConnected(false);
        log('Info: Closing connection.')
    };
}

function disconnect(){
    if(ws != null){
        ws.close();
        ws = null;
    }
    setConnected(false);
}

function echo(){
    if(ws != null){
        var message = document.getElementById('message').value;
        log('Sent: ' + message);
        ws.send(message);
        document.getElementById('message').value = '';
    }else{
        alert('Connection not established.');
    }
}

function log(message){
    var console = document.getElementById('logging');
    var p = document.createElement('p');
    p.appendChild(document.createTextNode(message));
    console.appendChild(p);
    while(console.childNodes.length > 10 ){
        console.removeChild(console.firstChild);
    }
    console.scrollTop = console.scrollHeight;
}