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
    <c:when test="${empty procedureResponse}">
			viewLoadedObject = null;
    </c:when>
    <c:otherwise>
			viewLoadedObject = ${procedureResponse};
    </c:otherwise>
</c:choose>

//columns & column settings for the grid
var columns = [
	{id:"cellno", name: "#", field:"cellno", resizable:false, cssClass:"cell-center", width:30},
	{id:"action", name: procedure.grid.act.title, field:"action", resizable:false, cssClass:"cell-center", width:65, formatter:Slick.Formatters.HTML},
    {id:"pid", name: procedure.grid.psak.title, field:"pid", resizable:false, cssClass:"cell-center", width:75},
    {id:"pprod", name: procedure.grid.pcode.title, field:"pprod", editable:true},
	{id:"pnome", name: procedure.grid.pcode.title, field:"pnome", editor:Slick.Editors.Text},
	{id:"col1", name:"test", field:"col1",  width:135, editable:true, cssClass:"pad-4-left", sortable:true, editor:Slick.Editors.Auto},
	{id:"pdesc", name: procedure.grid.pcode.title, field:"pdesc", editor:Slick.Editors.Text}
];

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
		   // var oData = new qat.model.reqCadastro(null, new qat.model.procedure(0,0,data[0].pcode,data[0].pdesc,0.0),true,true);qat.model.cadastro = function(_Id, _type, _nome, _descricao,_controlAcess)
			var oData = new qat.model.reqCadastro(null, new qat.model.cadastro(1,1,data[0].pnome,data[0].pdesc,null),true,true);
			rest_post_call('qat-sysmgmt-sample/services/rest/ProdutoService/insertCadastro', oData, fill_data, process_error);
			debugger;
			var oData = new qat.model.pagedInquiryRequest(null, 20, 0, true);
			rest_post_call('qat-sysmgmt-sample/services/rest/ProdutoService/fetchAllCadastros', {}, fill_data, process_error);

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

				var oData = new qat.model.reqProc(null, new qat.model.procedure(data[aRowChg[a]].pversion,data[aRowChg[a]].psak,data[aRowChg[a]].pcode,data[aRowChg[a]].pdesc,0.0), bList, true);
				rest_post_call('qat-webdaptive/procedure/api/updateBAS', oData, fill_data, process_error);
			}
		}

		function callDeleteWS(_procId)
		{
			onProcDataLoading.notify({});
		    var oData = new qat.model.reqProc(null, new qat.model.procedure(0,_procId,"","",0.0),true,true);
			rest_post_call('qat-webdaptive/procedure/api/deleteBAS', oData, fill_data, process_error);
		}

		function callRefreshWS(_i)
		{
			onProcDataLoading.notify({});
			var oData = new qat.model.refreshRequest(null, _i, true, true);
			rest_post_call('qat-webdaptive/procedure/api/refreshBAS', oData, fill_data, process_error);
		}
		</sec:authorize>

		function callPagedFetchWS(_iPageSize, _iStartPage)
		{
		    onProcDataLoading.notify({});
		    //if viewLOaddedObject filled by controller don't make a ajax call
			if (viewLoadedObject == null)
			{
			    var oData = new qat.model.pagedInquiryRequest(null, _iPageSize, _iStartPage, true);
				//rest_post_call('qat-webdaptive/procedure/api/fetchByRequestBAS', oData, fill_data, process_error);
				rest_post_call('qat-sysmgmt-sample/services/rest/ProdutoService/fetchAllCadastros', {}, fill_data, process_error);
			}
			else
			{
				rest_post_call('qat-sysmgmt-sample/services/rest/ProdutoService/fetchAllCadastros', {}, fill_data, process_error);
				fill_data(viewLoadedObject);
				viewLoadedObject = null;
			}
		}

		function fill_data(procResponse)
		{
			data = reuse_fill_data(procResponse,data,"cadastro");
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
$('#procGrid').keyup(function(e)
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

$('#refreshproc').click(function() {
	ploader.callRefreshWS(135);
});
</sec:authorize>
$('#listproc').click(function() {
	 ploader.callPagedFetchWS(20,0);
});
</script>
