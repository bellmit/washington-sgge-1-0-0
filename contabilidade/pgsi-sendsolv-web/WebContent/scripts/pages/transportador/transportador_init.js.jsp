<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>

<sec:authorize access="hasAnyRole('ROLE_DOMAIN ADMIN', 'ROLE_ADMIN', 'ROLE_CSR')">
<script type="text/javascript">
/**
 * @namespace pgsi.pages.transportador
 * @description The init namespace for the Location Page.
 */

$(document).ready(function()
{
	<c:choose>
		<c:when test="${not empty refresh}">
			var oFilterPreLoad = "refresh";
		</c:when>
		<c:when test="${empty filters}">
			var	oFilterPreLoad = null;
		</c:when>
		<c:otherwise>
			var	oFilterPreLoad = ${filters};
		</c:otherwise>
	</c:choose>

	$.pgsi.listener.wait({
		eventName 	: "transportadorList",
		arguments 	: ["table"],
		fnCallback 	: $.pgsi.progressBar.stopGlobal
	});

	/** * jQuery dataTable setup ** */
	pgsi.pages.transportador.transportadorTable = $('#data_list').dataTable($.pgsi.table.setTable(
	{
		id 			: "#data_list",
		sAjaxSource : "api/transportador/fetchall",
		bPreLoad	: true,

		ajax :
		{
			sObj		: "transportadorList",
			oRequest	: PagedInquiryRequest,
			fnRequest 	: function(){}
		},

		aoColumns :
			[
			{
				headerData 		: "CPF/CNPJ",
				order			: "name",
				mRender         : pgsi.pages.pessoa.fnCreateClienteNameLink,
				sDefaultContent : "",
				bSortable 		: false,
				sClass          : "name-col"
			},
			{
				headerData 		: "Nome",
				order			: "organization_column",
				mRender 		: pgsi.pages.pessoa.fnCreateNomeLink,
				sDefaultContent : "",
				bSortable 		: false
			},
			{
				headerData 		: "Profissao",
				order			: "city_column",
				mRender 		: pgsi.pages.pessoa.fnProfissao,
				mData	 		: "null",
				sDefaultContent : "",
				bSortable 		: false
			},
			{
				headerData 		: "Email",
				order			: "state_column",
				mRender 		: pgsi.pages.pessoa.fnEmail,
				sDefaultContent : "",
				bSortable 		: false
			},
			{
				headerData 		: "Telefone",
				order			: "country_column",
				mRender 		: pgsi.pages.pessoa.fnTelefone,
				sDefaultContent : "",
				bSortable 		: false
			},
			{
				headerData 		: "Convenio",
				order			: "sdn_status_column",
				mRender 		: pgsi.pages.pessoa.fnConvenio,
				sDefaultContent : "",
				bSortable 		: false
			},
			{
				headerData 		: "Endereco",
				order			: "phone_column",
				mRender 		: pgsi.pages.pessoa.fnEndereco,
				sDefaultContent : "",
				bSortable 		: false
			},
			{
				headerData 		: "Documentos",
				order			: "phone_column",
				mRender 		: pgsi.pages.pessoa.fnDocumento,
				sDefaultContent : "",
				bSortable 		: false
			},
			],


		<c:choose>
			<c:when test="${not empty refresh}">
				aaData : "refresh",
			</c:when>
			<c:when test="${empty response}">
				aaData : null,
		    </c:when>
		    <c:otherwise>
		    	aaData : ${response},
		    </c:otherwise>
		</c:choose>

		oSettings :
		{
			sortEnum      	: "",
			iDefaultCol   	: 0
		},

		rowCallback : function(nRow, aData, iDisplayIndex, oColumn) {

			var oActionSummary = "";
			var sButtonStatus = "";
			var sButtonDelete = "";

			<sec:authorize access="hasAnyRole('ROLE_DOMAIN ADMIN', 'ROLE_ADMIN')">

				if (aData.statusValue === 1) {
					sButtonStatus = '<a href="#" class="deactivate"><span class="icon-small-button deactivate icon-nav icon-minus-circle" title="Disable ' + aData.name + '"></a>';
				}

				else if ((aData.statusValue === 2)||(aData.statusValue === 3)|| (aData.statusValue === 4)){
					sButtonStatus = '<a href="#" class="active"><span class="icon-small-button active icon-nav icon-check-mark" title="' + $.pgsi.locale.get("pages.view.activate") + ' ' + aData.name + '"></span></a>';
				}

				sButtonDelete = '<a href="#"  class="icon-nav icon-trash-bin deleteDialog icon-small-button" title="' + $.pgsi.locale.get("commons.pages.delete") + ' ' + aData.name + '"></a>';

			</sec:authorize>

			oActionSummary = $('<div><div><a href="transportador/view?tab=info&transportadorId=' + aData.id + '" title="View '+aData.name+'" id="update" class="icon-nav icon-pencil alist icon-small-button"></a>'
				+ sButtonStatus
				+ sButtonDelete
				+pgsi.util.page.fnInsertButtonSDNSAR(aData,"transportador")+"</div></div>");

			oActionSummary.find('a.deleteDialog, a.active, a.deactivate ,a.sarDialog').click(function (e) {
				e.preventDefault();

				if (pgsi.util.page.fnIsSDNFlagged(aData.sdnstatus)) {
					return;
				}

				var fnCallBack = function(oResponse) {

					if (oResponse.operationSuccess == true) {

						// Validations for change pagination when delete one or more groups of last page.
						var iStart;
						var oSettings = pgsi.pages.transportador.transportadorTable.fnSettings();

							// If exist just one group at last page and this group is deleted, the pagination back to previous page.
							if (((oSettings._iRecordsDisplay - 1) % $('.dataTables_length').find('select').val() === 0)) {
								iStart = (oSettings._iRecordsDisplay - 1) - oSettings._iDisplayLength;
							}

						$.pgsi.table.reloadTable({
							table 		: pgsi.pages.transportador.transportadorTable,
							iStart 		: iStart
						});
					}else{
						pgsi.pages.sendsolv.fnDialogMessageError("",{},oResponse,null,$.pgsi.locale.get("commons.dialog.error.title"),true);
					}
				}


				if($(this).hasClass('deleteDialog'))
				{
					// Launch Delete Dialog
					var oRequest = new LocationMaintenanceRequest({transportador : {id : aData.id, name: aData.name }});

					pgsi.util.actiondialog.launchActionDialog(
						"deleteDialog",
						 pgsi.pages.business.dialogSettings.deleteDialog(
						 	"api/transportador/delete",
						 	 oRequest,
						 	 $.pgsi.locale.get("pages.transportador.dialog.title", oRequest.transportador.name),
						 	 fnCallBack,
						 	 $.pgsi.locale.get("commons.pages.erroView", $.pgsi.locale.get("commons.pages.transportador"))
						 ));

				}else if($(this).hasClass('active')){

					pgsi.util.page.fnUpdateStatus('api/transportador/fetch',parseInt(aData.id,10),'transportador',1,fnCallBack,"Activate Location for "+ aData.name, "<span>"+$.pgsi.locale.get("pages.person.dialog.status.question",$.pgsi.locale.get("pages.view.activate"),"Location")+"<br>" +$.pgsi.locale.get("pages.person.dialog.status.information",$.pgsi.locale.get("pages.view.activate"))+"<span>",true);
				}else if($(this).hasClass('deactivate')){
					pgsi.util.page.fnUpdateStatus('api/transportador/fetch',parseInt(aData.id,10),'transportador',2,fnCallBack,"Deactivate Location for "+ aData.name, "<span>"+$.pgsi.locale.get("pages.person.dialog.status.question",$.pgsi.locale.get("pages.view.deactivate"),"Location")+"<br>" +$.pgsi.locale.get("pages.person.dialog.status.information",$.pgsi.locale.get("pages.view.deactivate"))+"<span>",true);
				}else if($(this).hasClass('sarDialog')){
					pgsi.util.actiondialog.launchActionDialog(
							"dialogSARDetail",
							 pgsi.pages.sar.dialogSettings.dialogSARDetail(
								 $.pgsi.locale.get("commons.title.table.SAR"),
								 aData.id,
								 "transportador",
								 aData.name,
								 aData.key
							 ));
				}
			});

			$('td:eq(0)', nRow).hover (
				function ()
				{
					$(this).find('.icon-nav').removeClass('hide');
					$(this).append(oActionSummary);
				},

				function ()
				{
					$(this).find('.icon-nav').addClass('hide');
				}
			);
		},

		fnInitComplete: function (oSettings, json)
		{
			$(".dataTables_length select").outerWidth(62).selectmenu({
				appendTo: ".content.list",
  				change: function( event, ui ) {
  					$('#data_list_length').find("select").val(ui.item.value);
  					$("#data_list_length").find("select").trigger("change");
  					$("#load").find(".dataTables_length").find("select").selectmenu("refresh" );
  				}
			});

			$.pgsi.listener.notify({
				eventName 	: "transportadorList",
				arguments 	: ["table"]
			});
		}
	}
	));

	if (!$.pgsi.isNullOrUndefined(oFilterPreLoad)) {
		// Filters
		var aFilters = ['business'];

		var filters = pgsi.util.filter.filterArrayToObject(aFilters);
		pgsi.util.filter.init(oFilterPreLoad, filters, function(oResponse)
		{
			$.pgsi.filter.create(
			{
				element			: ".filter",
				tagsDiv			: ".filter-results-container div.first",
				title			: $.pgsi.locale.get("commons.pages.filterTitle"),
				table 			:  pgsi.pages.transportador.transportadorTable,
				filters 		: oResponse
			});
		});
	}

	//clear all Filter TODO
	$("#clear-all").on("click", function(e)
	{
		$.address.parameter("organization","");
		$.address.parameter("transportador","");
		pgsi.util.page.fnReloadTable(pgsi.pages.transportador.transportadorTable);
	});

});
</script>
</sec:authorize>