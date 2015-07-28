package com.prosperitasglobal.sendsolv.historico.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prosperitasglobal.sendsolv.filter.FilterFactory;
import com.prosperitasglobal.sendsolv.filter.model.response.FiltersResponse;
import com.prosperitasglobal.sendsolv.model.request.HistoricoInquiryRequest;
import com.qat.framework.model.SortExpression;
import com.qat.framework.model.SortExpression.Direction;

/**
 * The HistoricoViewController Class.
 *
 * @author Flavio Tosta, Washington Costa
 *
 */

@Controller
@RequestMapping("/historico")
public class HistoricoViewController extends HistoricoBaseController
{
	/** The URL mapping constants. */
	private static final String FETCH_LIST = "";

	/** The Constant FETCH_ADD. */
	private static final String FETCH_ADD = "/add";

	/** The Constant FETCH_EDIT. */
	private static final String FETCH_EDIT = "/edit";

	/** The Constant FETCH_VIEW. */
	private static final String FETCH_VIEW_TABS = "/view";

	/** The Constant FETCH_VIEW_INFO. */
	private static final String FETCH_VIEW = "/view/info";

	/** The Constant EDIT_VIEW. */
	private static final String EDIT_VIEW = "/editView";

	/** The view mapping constants . */
	private static final String VIEW_HISTORICO_MAIN = "/historico/historico_main";

	/** The Constant VIEW_HISTORICO_ADD. */
	private static final String VIEW_HISTORICO_ADD = "/historico/historico_create";

	/** The Constant VIEW_HISTORICO_VIEW. */
	private static final String VIEW_HISTORICO_VIEW = "/historico/historico_view";

	private static final String VIEW_HISTORICO_TABS = "/historico/historico_tabs";

	/** The Constant VIEW_HISTORICO_DIALOG_ADD. */
	private static final String VIEW_HISTORICO_DIALOG_ADD = "/historico/historico_dialog_create";

	/** The PagedInquiryRequest Constants. */
	private static final int START_PAGE_NUMBER = 0;

	/** The Constant INITIAL_PAGE_SIZE. */
	private static final int INITIAL_PAGE_SIZE = 25;

	/** The Constant HISTORICO_ID. */
	private static final String HISTORICO_ID = "historicoId";

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(HistoricoViewController.class);

	/** The Constant CONTROLLER_EXCEPTION_MSG. */
	private static final String CONTROLLER_EXCEPTION_MSG = "HistoricoViewController";

	private static final String BUSINESS = "BUSINESS";
	private static final String FILTERS = "filters";

	/** The filter factory. */
	private FilterFactory filterFactory;

	/**
	 * @return the filterFactory
	 */
	public FilterFactory getFilterFactory()
	{
		return filterFactory;
	}

	/**
	 * @param filterFactory the filterFactory to set
	 */
	@Resource
	public void setFilterFactory(FilterFactory filterFactory)
	{
		this.filterFactory = filterFactory;
	}

	/**
	 * Load list views.
	 *
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = FETCH_LIST, method = RequestMethod.GET)
	public ModelAndView loadList(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView(VIEW_HISTORICO_MAIN);

		// Check whether has initial load or not
		if (!isInitialLoad(request, modelAndView))
		{
			return modelAndView;
		}

		HistoricoInquiryRequest pagedInquiryRequest = new HistoricoInquiryRequest();
		pagedInquiryRequest.setStartPage(START_PAGE_NUMBER);
		pagedInquiryRequest.setPageSize(INITIAL_PAGE_SIZE);
		pagedInquiryRequest.setPreQueryCount(true);
		pagedInquiryRequest.addSortExpressions(new SortExpression("ID",
				Direction.Ascending));

		try
		{

			modelAndView.addObject(RESPONSE, getMapper()
					.writeValueAsString(fetchHistoricoByRequest(pagedInquiryRequest)));

			FiltersResponse filtersResponse = new FiltersResponse();
			getFilterFactory().configureFilter(BUSINESS, null, filtersResponse);

			modelAndView.addObject(FILTERS, getMapper().writeValueAsString(filtersResponse));
		}

		catch (Exception e)
		{
			if (LOG.isErrorEnabled())
			{
				LOG.error(CONTROLLER_EXCEPTION_MSG, e);
				modelAndView.addObject(RESPONSE, null);
			}
		}

		return modelAndView;
	}

	/**
	 * Load add/edit view.
	 *
	 * @param historicoId the historico id
	 * @return the model and view
	 */
	@RequestMapping(value = {FETCH_ADD, FETCH_EDIT}, method = RequestMethod.GET)
	public ModelAndView loadUpdate(@RequestParam(value = HISTORICO_ID, required = false) Integer historicoId,
			HttpServletRequest request)
	{

		return historicoEditMAV(historicoId, VIEW_HISTORICO_ADD, true, request);
	}

	@RequestMapping(value = {FETCH_VIEW_TABS}, method = RequestMethod.GET)
	public ModelAndView loadTabs(@RequestParam(value = HISTORICO_ID, required = true) Integer historicoId,
			HttpServletRequest request)
	{
		return new ModelAndView(VIEW_HISTORICO_TABS);
	}

	/**
	 * Load historico view.
	 *
	 * @param historicoId the historico id
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = {FETCH_VIEW}, method = RequestMethod.GET)
	public ModelAndView loadView(@RequestParam(value = HISTORICO_ID, required = true) Integer historicoId,
			HttpServletRequest request)
	{
		return historicoEditMAV(historicoId, VIEW_HISTORICO_VIEW, true, request);
	}

	/**
	 * Load view update.
	 *
	 * @param historicoId the historico id
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = {EDIT_VIEW}, method = RequestMethod.GET)
	public ModelAndView loadViewUpdate(@RequestParam(value = HISTORICO_ID, required = false) Integer historicoId,
			HttpServletRequest request)
	{

		return historicoEditMAV(historicoId, VIEW_HISTORICO_DIALOG_ADD, true, request);
	}

}
