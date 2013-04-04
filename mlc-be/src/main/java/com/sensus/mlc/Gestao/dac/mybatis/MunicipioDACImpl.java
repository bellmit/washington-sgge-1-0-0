Memo1
package com.sensus.mlc.CNAE.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.CNAE.model.Cnae
import com.sensus.mlc.CNAE.model.request.CnaeRequest
import com.sensus.mlc.CNAE.model.request.InquiryCnaeRequest
import com.sensus.mlc.CNAE.model.response.CnaeResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface ICnaeDAC
{

/**
* Update CNAE.
*
* @param CNAERequest the CNAE request
* @return the CNAE response
*/
public InternalResultsResponse<Cnae> updateCnae(CnaeRequest CNAERequest)

/**
* Delete CNAE.
*
* @param CNAERequest the CNAE request
* @return the CNAE response
*/
public InternalResponse deleteCnae(CnaeRequest CNAERequest)

/**
* Fetch all CNAE.
*
* @param inquiryCNAERequest the inquiryCNAE request
* @return the inquiry CNAE response
*/
public InternalResultsResponse<Cnae> fetchAllCnae(InquiryCnaeRequest inquiryCNAERequest)

/**
* Fetch CNAE by id.
*
* @param inquiryCNAERequest the inquiryCNAE request
* @return the internal results response
*/
public InternalResultsResponse<Cnae> fetchCnaeById(CnaeRequest CNAERequest)

/**
* Generate file csv.
*
* @param inquiryCnaeRequest the inquiry CNAE request
* @return the inquiry CNAE response
*/
public InternalResponse generateFileCSV(InquiryCnaeRequest inquiryCnaeRequest)

/**
* Fetch all CNAE types.
*
* @param request the request
* @return the CNAE response
*/
public CnaeResponse fetchAllCnaeTypes(Request request)

/**
* Fetch all CNAE filial.
*
* @param request the request
* @return the CNAE response
*/
public CnaeResponse fetchAllCnaeFilial(Request request)

public InternalResultsResponse<Cnae> insertCnae(CnaeRequest CNAERequest)
}


package com.sensus.mlc.bairro.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.bairro.model.Bairro
import com.sensus.mlc.bairro.model.request.BairroRequest
import com.sensus.mlc.bairro.model.request.InquiryBairroRequest
import com.sensus.mlc.bairro.model.response.BairroResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface IBairroDAC
{

/**
* Update bairro.
*
* @param bairroRequest the bairro request
* @return the bairro response
*/
public InternalResultsResponse<Bairro> updateBairro(BairroRequest bairroRequest)

/**
* Delete bairro.
*
* @param bairroRequest the bairro request
* @return the bairro response
*/
public InternalResponse deleteBairro(BairroRequest bairroRequest)

/**
* Fetch all bairro.
*
* @param inquirybairroRequest the inquirybairro request
* @return the inquiry bairro response
*/
public InternalResultsResponse<Bairro> fetchAllBairro(InquiryBairroRequest inquirybairroRequest)

/**
* Fetch bairro by id.
*
* @param inquirybairroRequest the inquirybairro request
* @return the internal results response
*/
public InternalResultsResponse<Bairro> fetchBairroById(BairroRequest bairroRequest)

/**
* Generate file csv.
*
* @param inquiryBairroRequest the inquiry bairro request
* @return the inquiry bairro response
*/
public InternalResponse generateFileCSV(InquiryBairroRequest inquiryBairroRequest)

/**
* Fetch all bairro types.
*
* @param request the request
* @return the bairro response
*/
public BairroResponse fetchAllBairroTypes(Request request)

/**
* Fetch all bairro filial.
*
* @param request the request
* @return the bairro response
*/
public BairroResponse fetchAllBairroFilial(Request request)

public InternalResultsResponse<Bairro> insertBairro(BairroRequest bairroRequest)
}


package com.sensus.mlc.MUNICIPIO.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.MUNICIPIO.model.Municipio
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.response.MunicipioResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface IMunicipioDAC
{

/**
* Update MUNICIPIO.
*
* @param MUNICIPIORequest the MUNICIPIO request
* @return the MUNICIPIO response
*/
public InternalResultsResponse<Municipio> updateMunicipio(MunicipioRequest MUNICIPIORequest)

/**
* Delete MUNICIPIO.
*
* @param MUNICIPIORequest the MUNICIPIO request
* @return the MUNICIPIO response
*/
public InternalResponse deleteMunicipio(MunicipioRequest MUNICIPIORequest)

/**
* Fetch all MUNICIPIO.
*
* @param inquiryMUNICIPIORequest the inquiryMUNICIPIO request
* @return the inquiry MUNICIPIO response
*/
public InternalResultsResponse<Municipio> fetchAllMunicipio(InquiryMunicipioRequest inquiryMUNICIPIORequest)

/**
* Fetch MUNICIPIO by id.
*
* @param inquiryMUNICIPIORequest the inquiryMUNICIPIO request
* @return the internal results response
*/
public InternalResultsResponse<Municipio> fetchMunicipioById(MunicipioRequest MUNICIPIORequest)

/**
* Generate file csv.
*
* @param inquiryMunicipioRequest the inquiry MUNICIPIO request
* @return the inquiry MUNICIPIO response
*/
public InternalResponse generateFileCSV(InquiryMunicipioRequest inquiryMunicipioRequest)

/**
* Fetch all MUNICIPIO types.
*
* @param request the request
* @return the MUNICIPIO response
*/
public MunicipioResponse fetchAllMunicipioTypes(Request request)

/**
* Fetch all MUNICIPIO filial.
*
* @param request the request
* @return the MUNICIPIO response
*/
public MunicipioResponse fetchAllMunicipioFilial(Request request)

public InternalResultsResponse<Municipio> insertMunicipio(MunicipioRequest MUNICIPIORequest)
}


package com.sensus.mlc.MUNICIPIO.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.MUNICIPIO.model.Municipio
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.response.MunicipioResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface IMunicipioDAC
{

/**
* Update MUNICIPIO.
*
* @param MUNICIPIORequest the MUNICIPIO request
* @return the MUNICIPIO response
*/
public InternalResultsResponse<Municipio> updateMunicipio(MunicipioRequest MUNICIPIORequest)

/**
* Delete MUNICIPIO.
*
* @param MUNICIPIORequest the MUNICIPIO request
* @return the MUNICIPIO response
*/
public InternalResponse deleteMunicipio(MunicipioRequest MUNICIPIORequest)

/**
* Fetch all MUNICIPIO.
*
* @param inquiryMUNICIPIORequest the inquiryMUNICIPIO request
* @return the inquiry MUNICIPIO response
*/
public InternalResultsResponse<Municipio> fetchAllMunicipio(InquiryMunicipioRequest inquiryMUNICIPIORequest)

/**
* Fetch MUNICIPIO by id.
*
* @param inquiryMUNICIPIORequest the inquiryMUNICIPIO request
* @return the internal results response
*/
public InternalResultsResponse<Municipio> fetchMunicipioById(MunicipioRequest MUNICIPIORequest)

/**
* Generate file csv.
*
* @param inquiryMunicipioRequest the inquiry MUNICIPIO request
* @return the inquiry MUNICIPIO response
*/
public InternalResponse generateFileCSV(InquiryMunicipioRequest inquiryMunicipioRequest)

/**
* Fetch all MUNICIPIO types.
*
* @param request the request
* @return the MUNICIPIO response
*/
public MunicipioResponse fetchAllMunicipioTypes(Request request)

/**
* Fetch all MUNICIPIO filial.
*
* @param request the request
* @return the MUNICIPIO response
*/
public MunicipioResponse fetchAllMunicipioFilial(Request request)

public InternalResultsResponse<Municipio> insertMunicipio(MunicipioRequest MUNICIPIORequest)
}


package com.sensus.mlc.UF.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.UF.model.Uf
import com.sensus.mlc.UF.model.request.UfRequest
import com.sensus.mlc.UF.model.request.InquiryUfRequest
import com.sensus.mlc.UF.model.response.UfResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface IUfDAC
{

/**
* Update UF.
*
* @param UFRequest the UF request
* @return the UF response
*/
public InternalResultsResponse<Uf> updateUf(UfRequest UFRequest)

/**
* Delete UF.
*
* @param UFRequest the UF request
* @return the UF response
*/
public InternalResponse deleteUf(UfRequest UFRequest)

/**
* Fetch all UF.
*
* @param inquiryUFRequest the inquiryUF request
* @return the inquiry UF response
*/
public InternalResultsResponse<Uf> fetchAllUf(InquiryUfRequest inquiryUFRequest)

/**
* Fetch UF by id.
*
* @param inquiryUFRequest the inquiryUF request
* @return the internal results response
*/
public InternalResultsResponse<Uf> fetchUfById(UfRequest UFRequest)

/**
* Generate file csv.
*
* @param inquiryUfRequest the inquiry UF request
* @return the inquiry UF response
*/
public InternalResponse generateFileCSV(InquiryUfRequest inquiryUfRequest)

/**
* Fetch all UF types.
*
* @param request the request
* @return the UF response
*/
public UfResponse fetchAllUfTypes(Request request)

/**
* Fetch all UF filial.
*
* @param request the request
* @return the UF response
*/
public UfResponse fetchAllUfFilial(Request request)

public InternalResultsResponse<Uf> insertUf(UfRequest UFRequest)
}


package com.sensus.mlc.CNAE.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.CNAE.model.Cnae
import com.sensus.mlc.CNAE.model.request.CnaeRequest
import com.sensus.mlc.CNAE.model.request.InquiryCnaeRequest
import com.sensus.mlc.CNAE.model.response.CnaeResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface ICnaeDAC
{

/**
* Update CNAE.
*
* @param CNAERequest the CNAE request
* @return the CNAE response
*/
public InternalResultsResponse<Cnae> updateCnae(CnaeRequest CNAERequest)

/**
* Delete CNAE.
*
* @param CNAERequest the CNAE request
* @return the CNAE response
*/
public InternalResponse deleteCnae(CnaeRequest CNAERequest)

/**
* Fetch all CNAE.
*
* @param inquiryCNAERequest the inquiryCNAE request
* @return the inquiry CNAE response
*/
public InternalResultsResponse<Cnae> fetchAllCnae(InquiryCnaeRequest inquiryCNAERequest)

/**
* Fetch CNAE by id.
*
* @param inquiryCNAERequest the inquiryCNAE request
* @return the internal results response
*/
public InternalResultsResponse<Cnae> fetchCnaeById(CnaeRequest CNAERequest)

/**
* Generate file csv.
*
* @param inquiryCnaeRequest the inquiry CNAE request
* @return the inquiry CNAE response
*/
public InternalResponse generateFileCSV(InquiryCnaeRequest inquiryCnaeRequest)

/**
* Fetch all CNAE types.
*
* @param request the request
* @return the CNAE response
*/
public CnaeResponse fetchAllCnaeTypes(Request request)

/**
* Fetch all CNAE filial.
*
* @param request the request
* @return the CNAE response
*/
public CnaeResponse fetchAllCnaeFilial(Request request)

public InternalResultsResponse<Cnae> insertCnae(CnaeRequest CNAERequest)
}


package com.sensus.mlc.BAIRRO.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.BAIRRO.model.Bairro
import com.sensus.mlc.BAIRRO.model.request.BairroRequest
import com.sensus.mlc.BAIRRO.model.request.InquiryBairroRequest
import com.sensus.mlc.BAIRRO.model.response.BairroResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface IBairroDAC
{

/**
* Update BAIRRO.
*
* @param BAIRRORequest the BAIRRO request
* @return the BAIRRO response
*/
public InternalResultsResponse<Bairro> updateBairro(BairroRequest BAIRRORequest)

/**
* Delete BAIRRO.
*
* @param BAIRRORequest the BAIRRO request
* @return the BAIRRO response
*/
public InternalResponse deleteBairro(BairroRequest BAIRRORequest)

/**
* Fetch all BAIRRO.
*
* @param inquiryBAIRRORequest the inquiryBAIRRO request
* @return the inquiry BAIRRO response
*/
public InternalResultsResponse<Bairro> fetchAllBairro(InquiryBairroRequest inquiryBAIRRORequest)

/**
* Fetch BAIRRO by id.
*
* @param inquiryBAIRRORequest the inquiryBAIRRO request
* @return the internal results response
*/
public InternalResultsResponse<Bairro> fetchBairroById(BairroRequest BAIRRORequest)

/**
* Generate file csv.
*
* @param inquiryBairroRequest the inquiry BAIRRO request
* @return the inquiry BAIRRO response
*/
public InternalResponse generateFileCSV(InquiryBairroRequest inquiryBairroRequest)

/**
* Fetch all BAIRRO types.
*
* @param request the request
* @return the BAIRRO response
*/
public BairroResponse fetchAllBairroTypes(Request request)

/**
* Fetch all BAIRRO filial.
*
* @param request the request
* @return the BAIRRO response
*/
public BairroResponse fetchAllBairroFilial(Request request)

public InternalResultsResponse<Bairro> insertBairro(BairroRequest BAIRRORequest)
}


package com.sensus.mlc.MUNICIPIO.dac


import com.sensus.common.model.request.Request
import com.sensus.common.model.response.InternalResponse
import com.sensus.common.model.response.InternalResultsResponse
import com.sensus.mlc.MUNICIPIO.model.Municipio
import com.sensus.mlc.MUNICIPIO.model.request.MunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.request.InquiryMunicipioRequest
import com.sensus.mlc.MUNICIPIO.model.response.MunicipioResponse

/**
* The Interface IActionDAC.
*
* @author - QAT Brazil.
*
*/
public interface IMunicipioDAC
{

/**
* Update MUNICIPIO.
*
* @param MUNICIPIORequest the MUNICIPIO request
* @return the MUNICIPIO response
*/
public InternalResultsResponse<Municipio> updateMunicipio(MunicipioRequest MUNICIPIORequest)

/**
* Delete MUNICIPIO.
*
* @param MUNICIPIORequest the MUNICIPIO request
* @return the MUNICIPIO response
*/
public InternalResponse deleteMunicipio(MunicipioRequest MUNICIPIORequest)

/**
* Fetch all MUNICIPIO.
*
* @param inquiryMUNICIPIORequest the inquiryMUNICIPIO request
* @return the inquiry MUNICIPIO response
*/
public InternalResultsResponse<Municipio> fetchAllMunicipio(InquiryMunicipioRequest inquiryMUNICIPIORequest)

/**
* Fetch MUNICIPIO by id.
*
* @param inquiryMUNICIPIORequest the inquiryMUNICIPIO request
* @return the internal results response
*/
public InternalResultsResponse<Municipio> fetchMunicipioById(MunicipioRequest MUNICIPIORequest)

/**
* Generate file csv.
*
* @param inquiryMunicipioRequest the inquiry MUNICIPIO request
* @return the inquiry MUNICIPIO response
*/
public InternalResponse generateFileCSV(InquiryMunicipioRequest inquiryMunicipioRequest)

/**
* Fetch all MUNICIPIO types.
*
* @param request the request
* @return the MUNICIPIO response
*/
public MunicipioResponse fetchAllMunicipioTypes(Request request)

/**
* Fetch all MUNICIPIO filial.
*
* @param request the request
* @return the MUNICIPIO response
*/
public MunicipioResponse fetchAllMunicipioFilial(Request request)

public InternalResultsResponse<Municipio> insertMunicipio(MunicipioRequest MUNICIPIORequest)
}


