convertBanco = function(stipo,iTamanho){
var sReturn = "";
	switch(stipo) {
	    case "String":
	        sReturn = "character varying("+iTamanho+")"
	        break;
	    case "Long":
	        sReturn = "bigint"
	        break;
	    default:
	        sReturn = stipo.toLowerCase();
	        break;
	}
	return sReturn;
}
dataAtualFormatada = function (){
    var data = new Date();
    var dia = data.getDate();
    if (dia.toString().length == 1)
      dia = "0"+dia;
    var mes = data.getMonth()+1;
    if (mes.toString().length == 1)
      mes = "0"+mes;
    var ano = data.getFullYear();  
    return dia+"/"+mes+"/"+ano+" "+data.getHours()+":"+data.getMinutes()+" : "+data.getSeconds();
}