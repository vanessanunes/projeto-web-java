function carregaUsuario(){
    var userStr = localStorage.getItem("user");
    if (!userStr){
        window.location="index.html"
    } else {
        var user = JSON.parse(userStr);
        document.getElementById("perfil").innerHTML = 
        "<h3>" + user.nome + "</h3><hr>" +
        user.email + "<br>" + 
        "Código: " + user.id + "<br>";
    }
    document.getElementById("fotousuario").innerHTML="<img src='"+ user.foto +"' width='20%'>";
}