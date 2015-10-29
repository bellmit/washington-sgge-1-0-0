package com.qat.samples.sysmgmt.produto.bas.rest;

import com.qat.samples.sysmgmt.model.request.FetchAllRequest;
import com.qat.samples.sysmgmt.model.request.FetchByIdRequest;
import com.qat.samples.sysmgmt.model.request.PagedInquiryRequest;
import com.qat.samples.sysmgmt.model.request.RefreshRequest;
import com.qat.samples.sysmgmt.produto.bai.IProdutoBAI;
import com.qat.samples.sysmgmt.produto.bas.IProdutoRESTBAS;
import com.qat.samples.sysmgmt.produto.model.request.ProdutoMaintenanceRequest;
import com.qat.samples.sysmgmt.produto.model.response.ProdutoResponse;

/**
 * Standard implementation of a BAS where the operations are delegated to a BAI.
 * Note the BAI is injected by Spring.
 */
public class ProdutoBAS implements IProdutoRESTBAS
{

	private IProdutoBAI produtoBAI; // injected by Spring through setter

	public IProdutoBAI getProdutoBAI()
	{
		return produtoBAI;
	}

	public void setProdutoBAI(IProdutoBAI produtoBAI)
	{
		this.produtoBAI = produtoBAI;
	}

	@Override
	public ProdutoResponse insertProduto(ProdutoMaintenanceRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoResponse updateProduto(ProdutoMaintenanceRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoResponse deleteProduto(ProdutoMaintenanceRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoResponse refreshProdutos(RefreshRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoResponse fetchAllProdutos(FetchAllRequest request)
	{
		System.out.println("teste");
		return null;
	}

	@Override
	public ProdutoResponse fetchProdutoById(FetchByIdRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoResponse fetchProdutosByRequest(PagedInquiryRequest request)
	{
		// TODO Auto-generated method stub
		return null;
	}

	// /** The produto bai. */
	// private IProdutoBAI produtoBAI; // injected by Spring through setter
	//
	// /**
	// * Sets the produto bai.
	// *
	// * @param produtoBAI the new produto bai
	// */
	// public void setProdutoBAI(IProdutoBAI produtoBAI)
	// {
	// this.produtoBAI = produtoBAI;
	// }
	//
	// /**
	// * Gets the produto bai.
	// *
	// * @return the produto bai
	// */
	// public IProdutoBAI getProdutoBAI()
	// {
	// return produtoBAI;
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#insertProduto(com.qat.samples.sysmgmt.model.request.
	// * ProdutoMaintenanceRequest)
	// */
	// @Override
	// public ProdutoResponse insertProduto(ProdutoMaintenanceRequest request)
	// {
	// return getProdutoBAI().insertProduto(request);
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#updateProduto(com.qat.samples.sysmgmt.model.request.
	// * ProdutoMaintenanceRequest)
	// */
	// @Override
	// public ProdutoResponse updateProduto(ProdutoMaintenanceRequest request)
	// {
	// return getProdutoBAI().updateProduto(request);
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#deleteProduto(com.qat.samples.sysmgmt.model.request.
	// * ProdutoMaintenanceRequest)
	// */
	// @Override
	// public ProdutoResponse deleteProduto(ProdutoMaintenanceRequest request)
	// {
	// return getProdutoBAI().deleteProduto(request);
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see
	// *
	// com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#refreshProdutos(com.qat.samples.sysmgmt.model.request.RefreshRequest)
	// */
	// @Override
	// public ProdutoResponse refreshProdutos(RefreshRequest request)
	// {
	// // This method is demo code only. Do not view this as a QAT Global Standard.
	// return getProdutoBAI().refreshProdutos(request);
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see
	// *
	// com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#fetchAllProdutos(com.qat.samples.sysmgmt.model.request.FetchAllRequest
	// * )
	// */
	// @Override
	// public ProdutoResponse fetchAllProdutos(ProdutoInquiryRequest request)
	// {
	// return getProdutoBAI().fetchAllProdutos(request);
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see
	// *
	// com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#fetchProdutoById(com.qat.samples.sysmgmt.model.request.FetchByIdRequest
	// * )
	// */
	// @Override
	// public ProdutoResponse fetchProdutoById(FetchByIdRequest request)
	// {
	// return getProdutoBAI().fetchProdutoById(request);
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see com.qat.samples.sysmgmt.bas.IProdutoRESTBAS#fetchProdutosByRequest(com.qat.samples.sysmgmt.model.request.
	// * PagedInquiryRequest)
	// */
	// @Override
	// public ProdutoResponse fetchProdutosByRequest(PagedInquiryRequest request)
	// {
	// return getProdutoBAI().fetchProdutosByRequest(request);
	// }
	//
	// @Override
	// public CadastroResponse insertCadastro(CadastroMaintenanceRequest request)
	// {
	// return getProdutoBAI().insertCadastro(request);
	// }
	//
	// @Override
	// public CadastroResponse updateCadastro(CadastroMaintenanceRequest request)
	// {
	// return getProdutoBAI().updateCadastro(request);
	// }
	//
	// @Override
	// public CadastroResponse deleteCadastro(CadastroMaintenanceRequest request)
	// {
	// return getProdutoBAI().deleteCadastro(request);
	// }
	//
	// @Override
	// public CadastroResponse refreshCadastros(RefreshRequest request)
	// {
	// return getProdutoBAI().refreshCadastros(request);
	// }
	//
	// @Override
	// public CadastroResponse fetchAllCadastros(CadastroInquiryRequest request)
	// {
	// return getProdutoBAI().fetchAllCadastros(request);
	// }
	//
	// @Override
	// public CadastroResponse fetchCadastroById(FetchByIdRequest request)
	// {
	// return getProdutoBAI().fetchCadastroById(request);
	// }
	//
	// @Override
	// public CadastroResponse fetchCadastrosByRequest(CadastroInquiryRequest request)
	// {
	// return getProdutoBAI().fetchCadastrosByRequest(request);
	// }
	//
	// @Override
	// public EmbalagemResponse insertEmbalagem(EmbalagemMaintenanceRequest request)
	// {
	// return getProdutoBAI().insertEmbalagem(request);
	// }
	//
	// @Override
	// public EmbalagemResponse updateEmbalagem(EmbalagemMaintenanceRequest request)
	// {
	// return getProdutoBAI().updateEmbalagem(request);
	// }
	//
	// @Override
	// public EmbalagemResponse deleteEmbalagem(EmbalagemMaintenanceRequest request)
	// {
	// return getProdutoBAI().deleteEmbalagem(request);
	// }
	//
	// @Override
	// public EmbalagemResponse fetchAllEmbalagems(EmbalagemInquiryRequest request)
	// {
	// return getProdutoBAI().fetchAllEmbalagems(request);
	// }
	//
	// @Override
	// public EmbalagemResponse insertUniMed(EmbalagemMaintenanceRequest request)
	// {
	// return getProdutoBAI().insertUniMed(request);
	// }
	//
	// @Override
	// public EmbalagemResponse updateUniMed(EmbalagemMaintenanceRequest request)
	// {
	// return getProdutoBAI().updateUniMed(request);
	// }
	//
	// @Override
	// public EmbalagemResponse deleteUniMed(EmbalagemMaintenanceRequest request)
	// {
	// return getProdutoBAI().deleteUniMed(request);
	// }
	//
	// @Override
	// public EmbalagemResponse fetchAllUniMeds(EmbalagemInquiryRequest request)
	// {
	// return getProdutoBAI().fetchAllUniMeds(request);
	// }
}