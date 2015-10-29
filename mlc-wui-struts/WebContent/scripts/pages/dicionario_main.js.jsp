<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>

<script type="text/javascript">
/**
 * 
 * @namespace sensus.pages.dicionario
 * @description The main namespace for the SmartPoint Page.
 * @fileoverview Defines the core functionality of the SmartPoint page.
 * @author Anke Doerfel-Parker
 *
 * The main namespace for the Group Page.
 */
sensus.pages.dicionario = {

	
	name              : "",    // The name
	isMap             : false, // The is Map
	count             : 0,     // The is options length
	orderBy           : 11,    // The order column
	sorting           : "asc", // The sorting asc or desc
	isFilter          : false, // The is Filter
	pagination        : 0,     // The table pagination
	initialized       : false, // Whether this is page has been fully initialized.
	numberOfRows      : 15,    // The table number of rows
	totalRecords      : 0,     // Total Records
	optionslength     : 0,     // The is options length
	inputFilterValue  : "",    // The is input filter value of checkboxes filters
	isAdvancedSearch  : false, // Is advanced search
	loadLayer         : {
		loadLayerTable  : null,
		loadLayerPage   : null
	},
	setLoadLayer      : function(pageLayer, tableLayer) {
		this.loadLayer.loadLayerTable = tableLayer;
		this.loadLayer.loadLayerPage = pageLayer;
	},
	fnReloadTable     : function() {

		//Reload table function
		sensus.widgets.datatable.reloadTable(sensus.pages.dicionario.smartpointTable);

	},
	processLightStatus : function(oStatusSetup){

		var sStatus       = '';

		if (oStatusSetup) {
			if(oStatusSetup.lightStatusEnum){
			
			if(oStatusSetup.lightStatusEnum == "ACTIVE"){
			
				sStatus = sensus.locale.get("smartpoint.status."+oStatusSetup.lightStatusEnum)+"|"+oStatusSetup.lightStatusEnum.toLowerCase();
				
			} else if(oStatusSetup.lightStatusEnum == "MAINTENANCE" || oStatusSetup.lightStatusEnum == "DEACTIVATED"){
			
				sStatus = sensus.locale.get("smartpoint.status."+oStatusSetup.lightStatusEnum)+"<br>" + $.date.dateFormat(oStatusSetup.date, sensus.settings.dateFormatMask+' h:i:s.fff A') +"|"+oStatusSetup.lightStatusEnum.toLowerCase();
			
			} else {
			
				if (oStatusSetup.statusExceptions.length) {
				
					sStatus = sensus.locale.get("smartpoint.status."+oStatusSetup.statusExceptions[0].statusExceptionTypeEnum)+"<br>" + $.date.dateFormat(oStatusSetup.date, sensus.settings.dateFormatMask+' h:i:s.fff A') +"|"+oStatusSetup.lightStatusEnum.toLowerCase();
				
				}
			
			}

			return sStatus;
			
		}	
	}
	},
	
	processDateAdded : function(oDate){
	
		var sDate = '';

		if (oDate) {

			sDate = $.date.dateFormat(oDate, sensus.settings.dateFormatMask);
			
		} 

		return sDate;
			
	
	},
	
	processEcoMode : function(ecoMode){ 
	
		var sEcoMode = "";
		if(sEcoMode){
						
			sEcoMode = sEcoMode.toFixed(0) + '%';
						
		} else {
			
			sEcoMode = 'N/A';
			
		}
		
		return sEcoMode;
	
	},
	
	processProtect : function(bProtect){ 
	
		var sProtect = "";
		// Change to Unlock Ico
		if (bProtect == false) {

			sProtect = '<span title="Unlocked" class="unlocked"></span>';
			
		} else if (bProtect == true) {

			// Add Locked ico by default 
			sProtect = '<span title="Locked" class="locked"></span>';

		}	
	
		return sProtect;
	},
	
	lightStatus      : {
		// Constant mapping the light statuses to their numeric ids
		
		BROWN_OUT_DETECTED : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');
			//Foramat Date, sDate = Plugin
			return {
				text  : sensus.locale.get("smartpoint.status.brownOutDetected") + '<br>'+sDate,
				css   : "warning"
			};

		},
		COMMUNICATION_FAIL : function (sDate) {
			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');
			return {
					text  : sensus.locale.get("smartpoint.status.communicationFail") + '<br>'+sDate,
					css   : "warning"
				};
		},
		ACTIVE : {
			text  : sensus.locale.get("smartpoint.status.active"),
			css   : ""
		},
		DEACTIVATED : function (sDate) {
			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');
			return {
				text  : sensus.locale.get("smartpoint.status.deactivated") + '<br>'+sDate,
				css   : "idle"
			};
		}, 
		MAINTENANCE : {
			text  : sensus.locale.get("smartpoint.status.maintenance"),
			css   : "idle"
		},
		LAMP_FAILURE : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');
			return {	
				text  : sensus.locale.get("smartpoint.status.lampFailure") + '<br>'+sDate,
				css   : "alerts"
			};

		},
		POWER_FAILURE : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {	
				text  : sensus.locale.get("smartpoint.status.powerFailure") + '<br>'+sDate,
				css   : "alerts"
			};
		},
		POWER_SURGE_DETECTED : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.powerSurgeDetected") + '<br>'+sDate,
				css   : "warning"
			};

		},
		METROLOGY_ERROR : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.metrologyerror") + '<br>'+sDate,
				css   : "alerts"
			};
		},
		METROLOGY_COM_FAILURE : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.metrologycomfailure") + '<br>'+sDate,
				css   : "alerts"
			};
		},
		BOARD_FAILURE : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.boardfailure") + '<br>'+sDate,
				css   : "alerts"
			};
		},
		HIGH_CURRENT : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.highcurrent") + '<br>'+sDate,
				css   : "warning"
			};
		},
		LOW_CURRENT : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.lowcurrent") + '<br>'+sDate,
				css   : "warning"
			};
		},
		REVERSE_ENERGY : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.reverseenergy") + '<br>'+sDate,
				css   : "warning"
			};
		},
		METROLOGY_RESET : function (sDate) {

			sDate = $.date.dateFormat(sDate, sensus.settings.dateFormatMask+' h:i:s.fff A');

			return {
				text  : sensus.locale.get("smartpoint.status.metrologyreset") + '<br>'+sDate,
				css   : "warning"
			};
		}
	},
	
	// Apply Protected
	applyProtected : function() {

		var isAllRows  = sensus.widgets.datatable.isAllRows,
			aIds       = sensus.widgets.datatable.selectedRows;

		if (isAllRows) {
			aIds = sensus.widgets.datatable.deselectedRows;
		}

		sensus.util.page.startProgressBar();

		sensus.pages.longrunningprocess.isClearSelect = true;
		sensus.util.ajaxaction.actionUrlAdress = sensus.settings.updateListLightProtected;
		sensus.util.ajaxaction.data = { 
			'lightRequest': new lightRequest(null, aIds, true, isAllRows) 
		};

		var iCountLights = $(".checked-count", "#actions").text();
		sensus.util.ajaxaction.sendActionDefault(sensus.locale.get("smartpoint.actions.locked.success", iCountLights), sensus.locale.get("action.longRunningProcessDialog.error"));

		if (sensus.util.ajaxaction.actionResult) {

			sensus.pages.dicionario.fnReloadTable();
			sensus.util.ajaxaction.actionResult = false;
			sensus.util.page.stopProgressBar(1);

		} else {

			sensus.util.page.stopProgressBar(1);

		}

		sensus.widgets.datatable.reloadTable(sensus.pages.dicionario.smartpointTable);

		return false;
	},

	// Apply Listen
	applyListen : function() {

		var isAllRows  = sensus.widgets.datatable.isAllRows,
			aIds       = sensus.widgets.datatable.selectedRows;

		if (isAllRows) {
			aIds = sensus.widgets.datatable.deselectedRows;
		}

		sensus.util.page.startProgressBar();

		sensus.util.ajaxaction.actionUrlAdress = sensus.settings.updateListLightProtected;
		sensus.util.ajaxaction.data = {
				'lightRequest': new lightRequest(null, aIds, false) 
		};

		var iCountLights = $(".checked-count", "#actions").text();
		sensus.util.ajaxaction.sendActionDefault(sensus.locale.get("smartpoint.actions.unlocked.success", iCountLights), sensus.locale.get("action.longRunningProcessDialog.error"));

		if (sensus.util.ajaxaction.actionResult) {

			sensus.pages.dicionario.fnReloadTable();
			sensus.util.ajaxaction.actionResult = false;
			sensus.util.page.stopProgressBar(1);

		} else {

			sensus.util.page.stopProgressBar(1);

		}

		sensus.widgets.datatable.reloadTable(sensus.pages.dicionario.smartpointTable);

		return false;
	},

	// Clear Alerts
	clearAlerts : function() {

		var isAllRows = sensus.widgets.datatable.isAllRows;
		var	aIds = isAllRows ? sensus.widgets.datatable.deselectedRows : sensus.widgets.datatable.selectedRows;
		var oSearchLight = { 'searchParameters' :  sensus.util.page.getSearchParameters()};
		var oRequest = { 'lightRequest': new lightRequest(null, aIds, false, isAllRows, null, true, oSearchLight, null, null, null, null, null) };

		$.ajaxValidator.fnMonitor(sensus.settings.clearSmartPointsAlerts, oRequest, false, null, sensus.locale.get("action.longRunningProcessDialog.confirm"), false);

		return false;
	},
	
	// Update Status
	updateStatus : function() {

		var isAllRows = sensus.widgets.datatable.isAllRows;
		var	aIds = sensus.widgets.datatable.isAllRows ? sensus.widgets.datatable.deselectedRows : sensus.widgets.datatable.selectedRows;
		var oSearchLight = { 'searchParameters' :  sensus.util.page.getSearchParameters()};
		var oRequest = { 'lightRequest': new lightRequest(null, aIds, false, isAllRows, null, true, oSearchLight, null, null, null, null, null) };
		
		if (aIds.length == 0) {
			aIds = [$.address.parameter('id')];
		}

		$.ajaxValidator.fnMonitor(sensus.settings.updateSmartPointsStatus, oRequest, false, null, sensus.locale.get("action.longRunningProcessDialog.confirm"), false);
		return false;
	},
	
	/**
	 * Reset min/max values
	 */
	resetValues :  function() {
		
		var isAllRows = sensus.widgets.datatable.isAllRows;
		var	aIds = sensus.widgets.datatable.isAllRows ? sensus.widgets.datatable.deselectedRows : sensus.widgets.datatable.selectedRows;
		var oRequest = {'lightRequest': new lightRequest(null, aIds, false, isAllRows, null, false, { 'searchParameters' :  sensus.util.page.getSearchParameters()})};
		
		$.ajaxValidator.fnMonitor(sensus.settings.resetValues, oRequest, false, null, sensus.locale.get("action.longRunningProcessDialog.confirm"), false);
	},
		
	/**
	 * Clear Override
	 */
	clearManualOverride : function() {
	
		var isAllRows = sensus.widgets.datatable.isAllRows;
		var	aIds = sensus.widgets.datatable.isAllRows ? sensus.widgets.datatable.deselectedRows : sensus.widgets.datatable.selectedRows;
		var oSearch = {propertyEnum: "SORT", value: "light.light_id"};
		var searchParameters = sensus.util.page.getSearchParameters();
		var oRequest = null;
		var bIsDetail = false;
		var fnCallback = null;
		
		if (aIds.length == 0 && $.address.parameter('id') != undefined) {
			aIds = [$.address.parameter('id')];
		}
		
		if ($('#content-controller').length) {
			bIsDetail = true;
			searchParameters = [oSearch];
			fnCallback = sensus.commons.modules.summaryData.lightInformation.fnUpdateLightInformation;
		}
		
		oRequest = { 'lightRequest': new lightRequest(aIds[0], aIds, null, isAllRows, null, true, { 'searchParameters' : searchParameters }, null, 'NONE', 'NONE', null, true)};

		$.ajaxValidator.fnMonitor(sensus.settings.controlLightUrl, oRequest, false, fnCallback, sensus.locale.get("action.longRunningProcessDialog.confirm"), bIsDetail);
	},
	
	// Ajax Call to generate CSV File
	generateCsvFile : function() {

		var aCurrentColumns = []; 

		// Get ID's from columns to send
		$("thead tr th:visible", "#smartpoint-table").each(function(key, element) {

		    if (element.id) {
		    	aCurrentColumns.push({ 'fieldName':element.id});
		    }

		});
		
		var sStatus = $.address.parameter('status');
		var aStatus = [];

		if (sStatus) {

			aStatus = sStatus.split("|");
			aStatus.pop();

		}

		var oSearch =  new searchLight(sensus.widgets.datatable.fnConvertEnum('LightStatusEnum', aStatus), sensus.util.page.getSearchParameters());												
		var data = { 'inquiryPaginationRequest' : new inquiryPaginationRequest(oSearch, aCurrentColumns) };
		sensus.pages.longrunningprocess.actionUrlAdress = "process/updateMonitorProcess.action";
		sensus.util.exportcsv.generateCSV(sensus.settings.insertProcess,sensus.settings.generateFile,data);

	},
	
	/**
	 * Clear all selected checkbox from Smartpoint Table.
	 * Usually used for callbacks.
	 */
	fnClearTableSelects : function () {
		sensus.widgets.datatable.clearSelectsFunction.call(sensus.pages.dicionario.smartpointTable);	
	}

};
</script>