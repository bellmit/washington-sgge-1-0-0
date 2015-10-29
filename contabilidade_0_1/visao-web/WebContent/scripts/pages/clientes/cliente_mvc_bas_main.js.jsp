<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var aRowChg = new Array();
var rowChg;
var data = new Array();
var pgrid;
var gridPager;
var pagingData = new qat.model.pageData(null,null,null,null);
var id = $("div[id*='tabs']" ).attr("id");
var viewLoadedObject;

//loads object if being served via controller
<c:choose>
    <c:when test="${empty clienteResponse}">
			viewLoadedObject = null;
    </c:when>
    <c:otherwise>
			viewLoadedObject = ${clienteResponse};
    </c:otherwise>
</c:choose>
console.log(viewLoadedObject);
//columns & column settings for the grid
var columns = [
	{id:"cellno", name: "#", field:"cellno", resizable:false, cssClass:"cell-center", width:30},
	{id:"action", name: procedure.grid.act.title, field:"action", resizable:false, cssClass:"cell-center", width:65, formatter:Slick.Formatters.HTML},
    {id:"clienteid", name: procedure.grid.psak.title, field:"clienteid", resizable:false, cssClass:"cell-center", width:75},
	{id:"type", name: procedure.grid.pcode.title, field:"type", editor:Slick.Editors.Text},
	{id:"nome", name: procedure.grid.pcode.title, field:"nome", editor:Slick.Editors.Text},
	{id:"sobrenome", name: procedure.grid.pcode.title, field:"sobrenome", editor:Slick.Editors.Text},
	{id:"usuario", name: procedure.grid.pcode.title, field:"usuario", editor:Slick.Editors.Text},
	{id:"senha", name: procedure.grid.pcode.title, field:"senha", editor:Slick.Editors.Text},
	{id:"email", name: procedure.grid.pcode.title, field:"email", editor:Slick.Editors.Text},
	{id:"enderecoid", name: procedure.grid.pcode.title, field:"enderecoid", editor:Slick.Editors.Text},
	{id:"eid", name: procedure.grid.pcode.title, field:"eid", editor:Slick.Editors.Text},
	{id:"logradouro", name: procedure.grid.pcode.title, field:"logradouro", editor:Slick.Editors.Text},
	{id:"bairro", name: procedure.grid.pcode.title, field:"bairro", editor:Slick.Editors.Text},
	{id:"estado", name: procedure.grid.pcode.title, field:"estado", editor:Slick.Editors.Text},
	{id:"cidade", name: procedure.grid.pcode.title, field:"cidade", editor:Slick.Editors.Text},
	{id:"numero", name: procedure.grid.pcode.title, field:"numero", editor:Slick.Editors.Text},
	{id:"cep", name: procedure.grid.pcode.title, field:"cep", editor:Slick.Editors.Text},
	{id:"nome", name: procedure.grid.pcode.title, field:"nome", editor:Slick.Editors.Text},
	{id:"complemento", name: procedure.grid.pcode.title, field:"complemento", editor:Slick.Editors.Text},
	{id:"documenroid", name: procedure.grid.pcode.title, field:"documenroid", editor:Slick.Editors.Text},
	{id:"did", name: procedure.grid.pcode.title, field:"did", editor:Slick.Editors.Text},
	{id:"rgInc", name: procedure.grid.pcode.title, field:"rgInc", editor:Slick.Editors.Text},
	{id:"cpfCnpj", name: procedure.grid.pcode.title, field:"cpfCnpj", editor:Slick.Editors.Text},
	{id:"razao", name: procedure.grid.pcode.title, field:"razao", editor:Slick.Editors.Text},
	{id:"dateNascimento", name: procedure.grid.pcode.title, field:"dateNascimento", editor:Slick.Editors.Text}
];

//_clienteid,_type, _nome,_sobrenome,_usuario,_senha,_email,_enderecoid,_eid,_endereco,_logradouro,_bairro,_estado,_cidade,_numero,_cep,_nome,_complemento,_documenroid,_did,_rgInc,_cpfCnpj,_razao,_dateNascimento
//grid options
var options =
{
	<sec:authorize  access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
	editable: true,
	</sec:authorize>
	enableAddRow: false,
	forceFitColumns: true,
	enableCellNavigation: true,
	explicitInitialization: true
};

//Custom RemoteModel Extension for SlickGrid
(function($)
{
	function RemoteModel()
	{
		var onProcDataLoading = new EventHelper();
		var onProcDataLoaded = new EventHelper();

		<sec:authorize  access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
		function callInsertWS()
		{
			onProcDataLoading.notify({});
		   // var oData = new qat.model.reqCadastro(null, new qat.model.procedure(0,0,data[0].pcode,data[0].pdesc,0.0),true,true);qat.model.cliente = function(_Id, _type, _nome, _descricao,_controlAcess)
			var oData = new qat.model.reqCliente(null, new qat.model.cliente(
			data[0].clienteid,data[0].type, data[0].nome,data[0].sobrenome,data[0].usuario,data[0].senha,data[0].email,data[0].enderecoid,data[0].eid,data[0].endereco,data[0].logradouro,data[0].bairro,data[0].estado,data[0].cidade,data[0].numero,data[0].cep,data[0].nome,data[0].complemento,data[0].documenroid,data[0].did,data[0].rgInc,data[0].cpfCnpj,data[0].razao,data[0].dateNascimento
			),true,true);
			rest_post_call('qat-sysmgmt-sample/services/rest/ClienteService/insertCliente', oData, fill_data, process_error);
			//var oData = new qat.model.pagedInquiryRequest(null, 20, 0, true);
		//	rest_post_call('qat-sysmgmt-sample/services/rest/ProdutoService/fetchAllCadastros', {}, fill_data, process_error);

		}

		function callUpdateWS()
		{
			var tempLength = aRowChg.length;
			if (tempLength > 0)
			{
				onProcDataLoading.notify({});
			}

			var bList = true;
			for(a=0; a < (tempLength); a++)
			{
				if (a==(tempLength-1))
				{
					bList = true;
				}
				else
				{
					bList = false;
				}

				var oData = new qat.model.reqCliente(null, new qat.model.cliente(
				data[aRowChg[a]].clienteid,data[aRowChg[a]].type, data[aRowChg[a]].nome,data[aRowChg[a]].sobrenome,data[aRowChg[a]].usuario,data[aRowChg[a]].senha,data[aRowChg[a]].email,data[aRowChg[a]].enderecoid,data[aRowChg[a]].eid,data[aRowChg[a]].endereco,data[aRowChg[a]].logradouro,data[aRowChg[a]].bairro,data[aRowChg[a]].estado,data[aRowChg[a]].cidade,data[aRowChg[a]].numero,data[aRowChg[a]].cep,data[aRowChg[a]].nome,data[aRowChg[a]].complemento,data[aRowChg[a]].documenroid,data[aRowChg[a]].did,data[aRowChg[a]].rgInc,data[aRowChg[a]].cpfCnpj,data[aRowChg[a]].razao,data[aRowChg[a]].dateNascimento
				//data[aRowChg[a]].pversion,data[aRowChg[a]].psak,data[aRowChg[a]].pcode,data[aRowChg[a]].pdesc,0.0
				), bList, true);
				rest_post_call('qat-sysmgmt-sample/services/rest/ClienteService/updateCliente', oData, fill_data, process_error);
			}
		}

		function callDeleteWS(_procId)
		{
			onProcDataLoading.notify({});
		    var oData = new qat.model.reqProc(null, new qat.model.cliente(0,_procId,"","",0.0),true,true);
			rest_post_call('qat-webdaptive/cliente/api/deleteBAS', oData, fill_data, process_error);
		}

		function callRefreshWS(_i)
		{
			onProcDataLoading.notify({});
			var oData = new qat.model.refreshRequest(null, _i, true, true);
			rest_post_call('qat-webdaptive/cliente/api/refreshBAS', oData, fill_data, process_error);
		}
		</sec:authorize>

		function callPagedFetchWS(_iPageSize, _iStartPage)
		{
		    onProcDataLoading.notify({});
		    //if viewLOaddedObject filled by controller don't make a ajax call
			if (viewLoadedObject == null)
			{
			    var oData = new qat.model.pagedInquiryRequest(null, _iPageSize, _iStartPage, true);
				//rest_post_call('qat-webdaptive/cliente/api/fetchByRequestBAS', oData, fill_data, process_error);
				rest_post_call('qat-sysmgmt-sample/services/rest/ClienteService/fetchAllClientes', {}, fill_data, process_error);
			}
			else
			{
				fill_data(viewLoadedObject);
				viewLoadedObject = null;
			}
		}

		function fill_data(procResponse)
		{
		console.log('ddddddd');
			data = reuse_fill_data(procResponse,data,"cliente");
			onProcDataLoaded.notify({});
		}

		function process_error(jqXHR, textStatus, errorThrown)
		{
			wd.core.process_xhr_error(jqXHR, textStatus, errorThrown);
			onProcDataLoaded.notify({});
		}

		function isProcDataLoaded()
		{
			if (data == undefined || data == null)
			{
				return false;
			}
			return true;
		}

		return{
			// properties
			"data": data,

			// methods
			"isProcDataLoaded": isProcDataLoaded,
			"callPagedFetchWS": callPagedFetchWS,
			<sec:authorize  access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
			"callDeleteWS": callDeleteWS,
			"callInsertWS": callInsertWS,
			"callUpdateWS": callUpdateWS,
			"callRefreshWS": callRefreshWS,
			</sec:authorize>
			// events
			"onProcDataLoading": onProcDataLoading,
			"onProcDataLoaded": onProcDataLoaded
		};
	};
	$.extend(true, window, { Slick: { Data: { RemoteModel: RemoteModel }}});
})(jQuery);

function requiredFieldValidator(value)
{
	if (wd.core.isEmpty(value))
	{
		wd.core.displayNotificationMessage('#StatusBar',procedure.requiredfield.msg, false, 'error', 5000);
		return {valid:false, msg:null};
	}
	else
	{
		return {valid:true, msg:null};
	}
};

function validateFields(rowValue)
{
	if (wd.core.isEmpty(data[rowValue].pcode))
	{
		pgrid.gotoCell(rowValue,3,true);
		$(pgrid.getActiveCellNode()).addClass("invalid");
		$(pgrid.getActiveCellNode()).stop(true,true).effect("highlight", {color:"red"}, 300);
		wd.core.displayNotificationMessage('#StatusBar',procedure.requiredfield.msg, false, 'error', 5000);
	}
	else if (wd.core.isEmpty(data[rowValue].pdesc))
	{
		pgrid.gotoCell(rowValue,4,true);
		$(pgrid.getActiveCellNode()).addClass("invalid");
		$(pgrid.getActiveCellNode()).stop(true,true).effect("highlight", {color:"red"}, 300);
		wd.core.displayNotificationMessage('#StatusBar',procedure.requiredfield.msg, false, 'error', 5000);
	}
	else
	{
		return true;
	}
	return false;
};

<sec:authorize  access="hasAnyRole('ROLE_DOMAIN USERS', 'ROLE_DOMAIN ADMINS')">
$('#CliGrid').keyup(function(e)
{
	if (e.keyCode == 13)
	{
		if (rowChg >= 1 )
		{
			ploader.callUpdateWS(aRowChg);
		}
		else
		{
		//	if (validateFields(0))
		//	{
				ploader.callInsertWS();
		//	}
		}
	}
});

$('#refreshCli').click(function() {
	ploader.callRefreshWS(135);
});
</sec:authorize>
$('#listCli').click(function() {
	 ploader.callPagedFetchWS(20,0);
});
</script>