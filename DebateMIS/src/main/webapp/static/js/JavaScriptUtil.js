const xhr = new XMLHttpRequest();
/*
添加Cookie
 */
function setCookie(name,value,time) {
    var date = new Date();
    date.setDate(date.getDate()+time);
    document.cookie = name + "=" + value + ";expires=" + date;
}

/*
获取Cookie
 */
function getCookie(name) {
    var arr = document.cookie.split(";");
    for (var i=0; i<arr.length; i++){
        var arr2 = arr[i].split("=");
        if (arr2[0] = name){
            return arr2[1];
        }
    }
    return null;
}

function updateNol(essayId){
    xhr.open('POST','http://localhost:8080/DebateMIS/getNol?essayId='+essayId);
    xhr.send();
    xhr.onreadystatechange = function (){
        if (xhr.readyState === 4){
            // console.log("4");
            // console.log(xhr.status);
            if (xhr.status >= 200 && xhr.status <300){
                var nol = xhr.response.nol;
                flag=false;
                return nol;
            }
        }
    }
}

function sendComment(comment){
    xhr.open('POST','http://localhost:8080/DebateMIS/getNol?essayId='+essayId);
    xhr.send();
    xhr.onreadystatechange = function (){
        if (xhr.readyState === 4){
            // console.log("4");
            // console.log(xhr.status);
            if (xhr.status >= 200 && xhr.status <300){
                nol = xhr.response;
                console.log(nol);
                btn.innerHTML=nol;
                flag=false;
            }
        }
    }
}

