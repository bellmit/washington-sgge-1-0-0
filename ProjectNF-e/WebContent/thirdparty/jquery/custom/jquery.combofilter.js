(function($) {
	$.widget("ui.combofilter", {
		_create : function() {
			var self = this;
			var select = this.element.hide();
			var input = $("<input>").attr('id', $(this.element).attr('id') + "_input").insertAfter(select).autocomplete({
				source : function(request, response) {
					var matcher = new RegExp(request.term, "i");
					response(select.children("option:not('.hide')").map(
							function() {
								var text = $(this).text();
								if (this.value && (!request.term || matcher.test(text)))
									return {
										id : this.value,
										label : text.replace(new RegExp(
												"(?![^&;]+;)(?!<[^<>]*)(" + $.ui.autocomplete.escapeRegex(request.term) + ")(?![^<>]*>)(?![^&;]+;)", "gi"),
												"$1"),
										value : text
									};
							}));
				},
				delay : 0,
				change : function(event, ui) {
					if (!ui.item) {
						// remove invalid value,
						// as it didn't match
						// anything
						//$(this).val($.sc.locale("widgets.combobox.prompt"));
						return false;
					}
					select.val(ui.item.id);
					self._trigger("selected", event, {
						item : select.find("[value='" + ui.item.id + "']")
					});

				},
				select : function(event, ui) {
					select.find("[value='" + ui.item.id + "']").addClass("hide");
					sensus.pages.smartpoint.inputFilterValue = ui.item.value;
				},
				minLength : 0
			}).addClass("ui-widget ui-widget-content ui-corner-left teste").focus(function() {
				if ($(this).attr('value') == $.sc.locale("widgets.combobox.prompt2")) {
					$(this).attr('value', '');
				}
			});
			$("<button class='ui-icon-list-ipt-check'>&nbsp;</button>").attr("tabIndex", -1).attr("title", $.sc.locale("widgets.combobox.title")).insertAfter(input).button( {
				icons : {
					primary : "ui-icon-triangle-1-s"
				},
				text : false
			}).removeClass("ui-corner-all").addClass("ui-corner-right ui-button-icon").click(function() {
				// close if already visible
				if (input.autocomplete("widget").is(":visible")) {
					input.autocomplete("close");
					return false;
				}
				// pass empty string as value to search for, displaying all
				// results
				input.autocomplete("search", "");
				input.focus();
				/**
				 * Modified by Anke Doerfel-Parker - this will stop the
				 * click event from getting through to other event handlers.
				 */
				return false;
			});
		}
	});

})(jQuery);
