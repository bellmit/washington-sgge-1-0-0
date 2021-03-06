<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>

<sec:authorize access="hasAnyRole('ROLE_DOMAIN ADMIN', 'ROLE_ADMIN')">

<script type="text/javascript">

$(document).ready(function()
{

	var iFornecedorId = pgsi.util.page.fnCheckXSS($.address.parameter("fornecedorId")) ? null : $.address.parameter("fornecedorId");

	//Attach Links to tabs
	$("#infoTab").attr('href', "fornecedor/view/info?fornecedorId=" + iFornecedorId);
	$('#pricingTab').attr('href',"fornecedor/?fornecedorId=" + iFornecedorId);

	var sTab = $.address.parameter("tab");
	var iActiveTab;

	if (!$.pgsi.isNullOrUndefined(sTab) && sTab.length > 0) {
		iActiveTab = $('*[data-tab="' + sTab + '"]').parent().index();
	}

	else {
		var iActiveTab = 0;
	}

	$("#tabs").tabs({
		active : iActiveTab,

		beforeLoad : function(event, ui) {
			$.pgsi.progressBar.start();

			// Setting correct tab parameter to the url
			$.address.parameter("tab", ui.tab[0].childNodes[1].dataset.tab);
			sTab = $.address.parameter("tab");
			// update active tab
			iActiveTab = $('*[data-tab="' + sTab + '"]').parent().index();
		},

		load: function(event, ui) {
			$.pgsi.progressBar.stopGlobal();
		}
	});
});

</script>

</sec:authorize>