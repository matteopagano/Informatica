/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let stringaFinale;
let stringaNome, stringaCognome, stringaSesso, stringaData, stringaComune;
let finNome, finCognome, finData;
let codice;

function calcola(){
	assumiDati();
	calcolaConsonanti();
	calcolaData();
	calcolaComune();
	calcolaCIN();
	alert(codice);
}

function assumiDati() {
	
    alert("u clicked the button");
    stringaNome = document.getElementById('nome').value;
    stringaCognome = document.getElementById('cognome').value;
    stringaData = document.getElementById('data').value;
	stringaComune = document.getElementById('luogo').value;
 	
    if (document.getElementById('male').checked)
        stringaSesso = 'male';
    else
        stringaSesso = 'female';

}

function calcolaConsonanti() {
    var contN = 0, contC = 0;                                       //prime 6 lettere
    for (var i = 0; i < stringaNome.length && contN < 3; i++) {
        var charTemp = stringaNome.toString().charAt(i);
        if (charTemp !== 'a' && charTemp !== 'e' && charTemp !== 'i' && charTemp !== 'o' && charTemp !== 'u') {
            if (finNome === undefined)
                finNome = charTemp;
            else
                finNome = finNome + charTemp;
            contN++;
        }
    }
    if (contN < 3) {
        for (var i = 0; i < stringaNome.length && contN < 3; i++) {
            var charTemp = stringaNome.toString().charAt(i);
            if (charTemp === 'a' || charTemp === 'e' || charTemp === 'i' || charTemp === 'o' || charTemp === 'u') {
                if (finNome === undefined)
                    finNome = charTemp;
                else
                    finNome = finNome + charTemp;
                contN++;
            }
        }
    } //fine nome

    for (var i = 0; i < stringaCognome.length && contC < 3; i++) {
        var charTemp = stringaCognome.toString().charAt(i);
        if (charTemp !== 'a' && charTemp !== 'e' && charTemp !== 'i' && charTemp !== 'o' && charTemp !== 'u') {
            if (finCognome === undefined)
                finCognome = charTemp;
            else
                finCognome = finCognome + charTemp;
            contC++;
        }
    }
    if (contC < 3) {
        for (var i = 0; i < stringaCognome.length && contC < 3; i++) {
            var charTemp = stringaCognome.toString().charAt(i);
            if (charTemp === 'a' || charTemp=== 'e' || charTemp === 'i' || charTemp === 'o' || charTemp === 'u') {
                if (finCognome === undefined)
                    finCognome = charTemp;
                else
                    finCognome = finCognome + charTemp;
                contC++;
            }
        }
    }//fine cognome
 
 
	codice=finCognome.toUpperCase();
	codice+=finNome.toUpperCase();
	}

	function calcolaData(){
    var years, month ,day;
	for(var i=0;i<4;i++){
		if (years === undefined)years = stringaData.toString().charAt(i);
                else            years = years +stringaData.toString().charAt(i);}
	
	for(var i=5;i<7;i++){
		if (month === undefined)month = stringaData.toString().charAt(i);
                else            month = month +stringaData.toString().charAt(i);}
	
	for(var i=8;i<10;i++){
		if (day === undefined)day = stringaData.toString().charAt(i);
                else            day = day +stringaData.toString().charAt(i);}


	finData=years.toString().charAt(2)+years.toString().charAt(3);
	
	switch(month){
		case '01': finData=finData+'A'; break;
		
		case '02': finData=finData+'B'; break;
		
		case '03': finData=finData+'C'; break;
			
		case '04': finData=finData+'D'; break;
			
		case '05': finData=finData+'E'; break;
			
		case '06': finData=finData+'H'; break;
			
		case '07': finData=finData+'L'; break;
			
		case '08': finData=finData+'M'; break;
			
		case '09': finData=finData+'P'; break;
				
		case '10': finData=finData+'R'; break;
					
		case '11': finData=finData+'S'; break;
						
		case '12': finData=finData+'T'; break;
					
	}
		if(stringaSesso==='female') day= +day + 40;

		finData= finData + day;
		codice+=finData;
	}
	
	function calcolaComune(){
		codice+=stringaComune.toString().toUpperCase();
	}
	
	function calcolaCIN(){
		
	}
	

				
	



