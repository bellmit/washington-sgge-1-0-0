package com.sensus.mlc.gestao.dac;

import com.sensus.common.model.request.Request;
import com.sensus.common.model.response.InternalResponse;
import com.sensus.common.model.response.InternalResultsResponse;
import com.sensus.mlc.gestao.model.Filial;
import com.sensus.mlc.gestao.model.request.FilialRequest;
import com.sensus.mlc.gestao.model.request.InquiryFilialRequest;
import com.sensus.mlc.gestao.model.response.FilialResponse;


/**
* The Interface IActionDAC.
*
* @author - Washington
*
*/
public interface IFilialDAC
{

/**
* Update filial.
*
* @param filialRequest the filial request
* @return the filial response
*/
public InternalResultsResponse<Filial> updateFilial(FilialRequest filialRequest);

/**
* Delete filial.
*
* @param filialRequest the filial request
* @return the filial response
*/
public InternalResponse deleteFilial(FilialRequest filialRequest);

/**
* Fetch all filial.
*
* @param inquiryfilialRequest the inquiryfilial request
* @return the inquiry filial response
*/
public InternalResultsResponse<Filial> fetchAllFilial(InquiryFilialRequest inquiryfilialRequest);

/**
* Fetch filial by id.
*
* @param inquiryfilialRequest the inquiryfilial request
* @return the internal results response
*/
public InternalResultsResponse<Filial> fetchFilialById(FilialRequest filialRequest);

/**
* Generate file csv.
*
* @param inquiryFilialRequest the inquiry filial request
* @return the inquiry filial response
*/
public InternalResponse generateFileCSV(InquiryFilialRequest inquiryFilialRequest);

/**
* Fetch all filial types.
*
* @param request the request
* @return the filial response
*/
public FilialResponse fetchAllFilialTypes(Request request);

/**
* Fetch all filial filial.
*
* @param request the request
* @return the filial response
*/
public FilialResponse fetchAllFilialFilial(Request request);

public InternalResultsResponse<Filial> insertFilial(FilialRequest filialRequest);
}


