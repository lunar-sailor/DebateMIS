button.addEventListener('click',setCookie)
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
        return null;
    }
}