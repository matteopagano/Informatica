
let nome;
let cognome;
let matricola;
let regioneDiResidenza;
let email;
let telefono;
let richiesteParticolari;

function getView(){
   nome=document.getElementById("nome");
   cognome=document.getElementById("cognome");
   matricola=document.getElementById("matricola");
   regioneDiResidenza=document.getElementById("regione");
   email=document.getElementById("mail");
   telefono=document.getElementById("telefono");
   richiesteParticolari=document.getElementById("richiesteparticolari");
}
function invia(){
    var error="";
    if(nome.value==""){
        error+="Campo Nome vuoto!\n";
    }
    if(cognome.value==""){
        error+="Campo Cognome vuoto!\n";
    }
    if(matricola.value>=0){
        error+="Campo Matricola vuoto!\n";
    }
    if(email.value==""){
        error+="Campo Email vuoto!\n";
    }
    if(telefono.value==""){
        error+="Campo Telefono vuoto!\n";
    }
    if(regioneDiResidenza.value=="None"){
        error+="Campo RegioneDiResidenza vuoto!\n";
    }
    if(error != ""){
        alert(error);
    }else{
        alert("No error");
    }
}
function reset(){
    
}


