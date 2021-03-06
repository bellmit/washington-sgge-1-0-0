unit UDLLNFFISCAL;

interface

type
 TNFISCAL = Class
    private
    FDCNUMERO,FCDPEDIDO,FNOPARCELA,FFORNECEDOR,FNATUREZA,FIND_OPER,FCOD_PART,FIND_EMIT,FCODNFE,FCOD_EMPRESA,FCod_Filial : Integer;
    FDCSERIE,FDCORDEM,FDCTIPO,FSTATUS,FCFOP,FSTATUST,FTPSITUACAOT,FCOD_SIT,FCOD_GRUPO_TENSAO,FCHV_CTE,FTP_CT,FCHV_CTE_REF,FIND_FRT :String;
    FVLNOTA,FICMS,FFRETE,FIPI,FST,FVLTITULO,FQUANTIDADE,FAQUIS,Fvl_PIS,FVLVENDA,FPOR,FICMSI,FVL_DOC,FVL_DESC,FVL_FORN,FVL_SERV_NT,FVL_TERC,FVL_DA,FVL_BC_ICMS,FVL_ICMS,FVL_BC_ICMS_ST,FVL_ICMS_ST,FCOD_INF,FVL_COFINS,FTP_LIGACAO:Double;
    FDTEMISSAO,FDTENTRADA,FDTVENCIMENTO:TDateTime;
    protected
     // IND_OPER,IND_EMIT,CODNFE,COD_EMPRESA,Cod_Filial
      function  GetIND_OPER      : Integer;
      function  GetIND_EMIT      : Integer;
      function  GetCODNFE        : Integer;
      function  GetCOD_EMPRESA   : Integer;
      function  GetCod_Filial    : Integer;
      function  GetDCNUMERO      : Integer;
      function  GetCDPEDIDO      : Integer;
      function  GetFORNECEDOR    : Integer;
      function  GetNATUREZA      : Integer;
      function  GetCOD_PART      : Integer;
      function  GetCOD_SIT       : string;
      function  GetCOD_GRUPO_TENSAO     : string;
      function  GetCHV_CTE       : string;
      function  GetTP_CT         : string;
      function  GetCHV_CTE_REF   : string;
      function  GetIND_FRT       : string;
      function  GetDCSERIE       : string;
      function  GetDCORDEM       : string;
      function  GetDCTIPO        : string;
      function  GetCFOP          : string;
      function  GetVL_DOC        : DOUBLE;
      function  GetVL_DESC          : DOUBLE;
      function  GetVL_FORN       : DOUBLE;
      function  GetVL_SERV_NT    : DOUBLE;
      function  GetVL_TERC       : DOUBLE;
      function  GetVL_DA         : DOUBLE;
      function  GetVL_BC_ICMS    : DOUBLE;
      function  GetVL_ICMS     : DOUBLE;
      function  GetVL_ICMS_ST     : DOUBLE;
      function  GetVL_BC_ICMS_ST : DOUBLE;
      function  GetVL_PIS        : DOUBLE;
      function  GetCOD_INF       : DOUBLE;
      function  GetVL_COFINS     : DOUBLE;
      function  GetTP_LIGACAO    : DOUBLE;
      function  GetIPI           : DOUBLE;
      function  GetDTEMISSAO     :TDATETIME;
      function  GetDTENTRADA     :TDATETIME;
      function  GetDTVENCIMENTO  :TDATETIME;

      Procedure  SetIND_OPER      (Value : Integer);
      Procedure  SetIND_EMIT      (Value : Integer);
      Procedure  SetCODNFE        (Value : Integer);
      Procedure  SetCOD_EMPRESA   (Value : Integer);
      Procedure  SetCod_Filial    (Value : Integer);
      Procedure  SetDCNUMERO      (Value : Integer);
      Procedure  SetCDPEDIDO      (Value : Integer);
      Procedure  SetFORNECEDOR    (Value : Integer);
      Procedure  SetNATUREZA      (Value : Integer);
      Procedure  SetCOD_PART      (Value : Integer);
      Procedure  SetCOD_SIT       (Value : string);
      Procedure  SetCOD_GRUPO_TENSAO     (Value : string);
      Procedure  SetCHV_CTE       (Value : string);
      Procedure  SetTP_CT         (Value : string);
      Procedure  SetCHV_CTE_REF   (Value : string);
      Procedure  SetIND_FRT       (Value : string);
      Procedure  SetDCSERIE       (Value : string);
      Procedure  SetDCORDEM       (Value : string);
      Procedure  SetDCTIPO        (Value : string);
      Procedure  SetCFOP          (Value : string);
      Procedure  SetVL_DOC        (Value : Double);
      Procedure  SetVL_DESC       (Value : Double);
      Procedure  SetVL_FORN       (Value : Double);
      Procedure  SetVL_SERV_NT    (Value : Double);
      Procedure  SetVL_TERC       (Value : Double);
      Procedure  SetVL_PIS         (Value : Double);
      Procedure  SetVL_DA         (Value : Double);
      Procedure  SetVL_BC_ICMS    (Value : Double);
      Procedure  SetVL_ICMS     (Value : Double);
      Procedure  SetVL_BC_ICMS_ST (Value : Double);
      Procedure   SetVL_ICMS_ST     (Value : Double);
      Procedure  SetCOD_INF       (Value : Double);
      Procedure  SetVL_COFINS     (Value : Double);
      Procedure  SetTP_LIGACAO    (Value : Double);
      Procedure  SetIPI           (Value : Double);
      Procedure  SetDTEMISSAO     (Value : TDateTime);
      Procedure  SetDTENTRADA     (Value : TDateTime);
      Procedure  SetDTVENCIMENTO  (Value : TDateTime);


    public
      property  IND_OPER      : Integer read GetIND_OPER     write SetIND_OPER;
      property  IND_EMIT      : Integer read GetIND_EMIT     write SetIND_EMIT;
      property  CODNFE        : Integer read GetCODNFE       write SetCODNFE;
      property  COD_EMPRESA   : Integer read GetCOD_EMPRESA  write SetCOD_EMPRESA;
      property  Cod_Filial    : Integer read GetCod_Filial   write SetCod_Filial;
      property  DCNUMERO      : Integer read GetDCNUMERO     write SetDCNUMERO;
      property  CDPEDIDO      : Integer read GetCDPEDIDO     write SetCDPEDIDO;
      property  FORNECEDOR    : Integer  read GetFORNECEDOR   write SetFORNECEDOR;
      property  NATUREZA      : Integer read GetNATUREZA     write SetNATUREZA;
      property  COD_PART      : Integer  read GetCOD_PART      write SetCOD_PART;
      property  COD_SIT       : string  read GetCOD_SIT      write SetCOD_SIT;
      property  COD_GRUPO_TENSAO       : string  read GetCOD_GRUPO_TENSAO      write SetCOD_GRUPO_TENSAO;
      property  CHV_CTE       : string  read GetCHV_CTE      write SetCHV_CTE;
      property  TP_CT         : string  read GetTP_CT        write SetTP_CT;
      property  CHV_CTE_REF   : string  read GetCHV_CTE_REF  write SetCHV_CTE_REF;
      property  IND_FRT       : string  read GetIND_FRT      write SetIND_FRT;
      property  DCSERIE       : string  read GetDCSERIE      write SetDCSERIE;
      property  DCORDEM       : string  read GetDCORDEM      write SetDCORDEM;
      property  DCTIPO        : string  read GetDCTIPO       write SetDCTIPO;
      property  CFOP          : String  read GetCFOP         write SetCFOP;
      property  VL_pis        : DOUBLE read GetVL_PIS        write SetVL_PIS;
      property  VL_DOC        : DOUBLE read GetVL_DOC        write SetVL_DOC;
      property  VL_DESC       : DOUBLE read GetVL_DESC       write SetVL_DESC;
      property  VL_FORN       : DOUBLE read GetVL_FORN          write SetVL_FORN;
      property  VL_SERV_NT    : DOUBLE read GetVL_SERV_NT           write SetVL_SERV_NT;
      property  VL_TERC       : DOUBLE read GetVL_TERC            write SetVL_TERC;
      property  VL_DA         : DOUBLE read GetVL_DA          write SetVL_DA;
      property  VL_BC_ICMS    : DOUBLE read GetVL_BC_ICMS           write SetVL_BC_ICMS;
      property  VL_ICMS       : DOUBLE read GetVL_ICMS           write SetVL_ICMS;
       property  VL_BC_ICMS_ST : DOUBLE read GetVL_BC_ICMS_ST         write SetVL_BC_ICMS_ST;
       property  VL_ICMS_ST : DOUBLE read GetVL_ICMS_ST         write SetVL_ICMS_ST;
      property  COD_INF       : DOUBLE read GetCOD_INF    write SetCOD_INF;
      property  VL_COFINS     : DOUBLE read GetVL_COFINS         write SetVL_COFINS;
      property  TP_LIGACAO    : DOUBLE read GetTP_LIGACAO       write SetTP_LIGACAO;
      property  IPI           : DOUBLE read GetIPI          write SetIPI;
      property  DTENTRADA     : TDatetime read GetDTENTRADA       write SetDTENTRADA ;
      property  DTEMISSAO     : TDatetime read GetDTEMISSAO       write SetDTEMISSAO ;
      property  DTVENCIMENTO  : TDatetime read GetDTVENCIMENTO    write SetDTVENCIMENTO ;

  End;
implementation

uses SysUtils;
      function  TNFISCAL.GetIND_OPER      : Integer;
      Begin
      Result := Self.FIND_OPER;
      End;
      function  TNFISCAL.GetIND_EMIT      : Integer;
      Begin
      Result := Self.FIND_EMIT;
      End;
      function  TNFISCAL.GetCODNFE        : Integer;
      Begin
      Result := Self.FCODNFE;
End;
      function  TNFISCAL.GetCOD_EMPRESA   : Integer;
      Begin
      Result := Self.FCOD_EMPRESA;
End;
      function  TNFISCAL.GetCod_Filial    : Integer;
      Begin
      Result := Self.FCod_Filial;
End;
      function  TNFISCAL.GetDCNUMERO      : Integer;
      Begin
      Result := Self.FDCNUMERO;
End;
      function  TNFISCAL.GetCDPEDIDO      : Integer;
      Begin
      Result := Self.FCDPEDIDO;
End;
      function  TNFISCAL.GetFORNECEDOR    : Integer;
      Begin
      Result := Self.FFORNECEDOR;
End;
      function  TNFISCAL.GetNATUREZA      : Integer;
      Begin
      Result := Self.FNATUREZA;
End;
      function  TNFISCAL.GetCOD_PART      : Integer;
      Begin
      Result := Self.FCOD_PART ;
End;
      function  TNFISCAL.GetCOD_SIT       : string;
      Begin
      Result := Self.FCOD_SIT;
End;
      function  TNFISCAL.GetCOD_GRUPO_TENSAO     : string;
      Begin
      Result := Self.FCOD_GRUPO_TENSAO;
End;
      function  TNFISCAL.GetCHV_CTE       : string;
      Begin
      Result := Self.FCHV_CTE;
End;
      function  TNFISCAL.GetTP_CT         : string;
      Begin
      Result := Self.FTP_CT;
End;
      function  TNFISCAL.GetCHV_CTE_REF   : string;
      Begin
      Result := Self.FCHV_CTE_REF;
End;
      function  TNFISCAL.GetIND_FRT       : string;
      Begin
      Result := Self.FIND_FRT;
End;
      function  TNFISCAL.GetDCSERIE       : string;
      Begin
      Result := Self.FDCSERIE;
End;
      function  TNFISCAL.GetDCORDEM       : string;
      Begin
      Result := Self.FDCORDEM;
End;
      function  TNFISCAL.GetDCTIPO        : string;
      Begin
      Result := Self.FDCTIPO;
End;
      function  TNFISCAL.GetCFOP          : string;
      Begin
      Result := Self.FCFOP;
End;
         function  TNFISCAL.GetVL_PIS        : DOUBLE;
      Begin
      Result := Self.FVL_PIS;
End;


      function  TNFISCAL.GetVL_DOC        : DOUBLE;
      Begin
      Result := Self.FVL_DOC;
End;
      function  TNFISCAL.GETVL_DESC          : DOUBLE;
      Begin
      Result := Self.FVL_DESC;
End;
      function  TNFISCAL.GetVL_FORN       : DOUBLE;
      Begin
      Result := Self.FVL_FORN;
End;
      function  TNFISCAL.GetVL_SERV_NT    : DOUBLE;
      Begin
      Result := Self.FVL_SERV_NT;
End;
      function  TNFISCAL.GetVL_TERC       : DOUBLE;
      Begin
      Result := Self.FVL_TERC;
End;
      function  TNFISCAL.GetVL_DA         : DOUBLE;
      Begin
      Result := Self.FVL_DA;
End;
      function  TNFISCAL.GetVL_BC_ICMS    : DOUBLE;
      Begin
      Result := Self.FVL_BC_ICMS;
End;
      function  TNFISCAL.GetVL_ICMS     : DOUBLE;
      Begin
      Result := Self.FVL_ICMS;
End;
      function  TNFISCAL.GetVL_BC_ICMS_ST : DOUBLE;
      Begin
      Result := Self.FVL_BC_ICMS_ST ;
End;
      function  TNFISCAL.GetVL_ICMS_ST : DOUBLE;
      Begin
      Result := Self.FVL_ICMS_ST ;
      End;


      function  TNFISCAL.GetCOD_INF       : DOUBLE;
      Begin
      Result := Self.FCOD_INF;
End;
      function  TNFISCAL.GetVL_COFINS     : DOUBLE;
      Begin
      Result := Self.FVL_COFINS;
End;
      function  TNFISCAL.GetTP_LIGACAO    : DOUBLE;
      Begin
      Result := Self.FTP_LIGACAO;
End;
      function  TNFISCAL.GetIPI           : DOUBLE;
      Begin
      Result := Self.FIPI;
End;
      function  TNFISCAL.GetDTEMISSAO     :TDATETIME;
      Begin
      Result := Self.FDTEMISSAO;
End;
      function  TNFISCAL.GetDTENTRADA     :TDATETIME;
      Begin
      Result := Self.FDTENTRADA;
End;
      function  TNFISCAL.GetDTVENCIMENTO  :TDATETIME;
      Begin
      Result := Self.FDTVENCIMENTO;
End;
procedure   TNFISCAL.SetVL_ICMS_ST   (Value : Double);
    Begin
      Self.FVL_ICMS_ST := Value;
    End;

      Procedure  TNFISCAL.SetIND_OPER      (Value : Integer);
      Begin
      Self.FIND_OPER := Value;
End;
      Procedure  TNFISCAL.SetIND_EMIT      (Value : Integer);
      Begin
      Self.FIND_EMIT := Value;
      End;
      Procedure  TNFISCAL.SetCODNFE        (Value : Integer);
      Begin
      Self.FCODNFE := Value;
End;
      Procedure  TNFISCAL.SetCOD_EMPRESA   (Value : Integer);
      Begin
      Self.FCOD_EMPRESA := Value;
End;
      Procedure  TNFISCAL.SetCod_Filial    (Value : Integer);
      Begin
      Self.FCod_Filial := Value;
End;
      Procedure  TNFISCAL.SetDCNUMERO      (Value : Integer);
      Begin
      Self.FDCNUMERO := Value;
      End;
      Procedure  TNFISCAL.SetCDPEDIDO      (Value : Integer);
      Begin
      Self.FCDPEDIDO := Value;
End;
      Procedure  TNFISCAL.SetFORNECEDOR    (Value : Integer);
      Begin
      Self.FFORNECEDOR := Value;
End;
      Procedure  TNFISCAL.SetNATUREZA      (Value : Integer);
      Begin
      Self.FNATUREZA := Value;
End;
      Procedure  TNFISCAL.SetCOD_PART      (Value : Integer);
      Begin
      Self.FCOD_PART := Value;
End;
      Procedure  TNFISCAL.SetCOD_SIT       (Value : string);
      Begin
      Self.FCOD_SIT := Value;
End;
      Procedure  TNFISCAL.SetCOD_GRUPO_TENSAO     (Value : string);
      Begin
      Self.FCOD_GRUPO_TENSAO := Value;
End;
      Procedure  TNFISCAL.SetCHV_CTE       (Value : string);
      Begin
      Self.FCHV_CTE := Value;
End;
      Procedure  TNFISCAL.SetTP_CT         (Value : string);
      Begin
      Self.FTP_CT := Value;
End;
      Procedure  TNFISCAL.SetCHV_CTE_REF   (Value : string);
      Begin
      Self.FCHV_CTE_REF := Value;
End;
      Procedure  TNFISCAL.SetIND_FRT       (Value : string);
      Begin
      Self.FIND_FRT := Value;
End;
      Procedure  TNFISCAL.SetDCSERIE       (Value : string);
      Begin
      Self.FDCSERIE := Value;
End;
      Procedure  TNFISCAL.SetDCORDEM       (Value : string);
      Begin
      Self.FDCORDEM := Value;
End;
      Procedure  TNFISCAL.SetDCTIPO        (Value : string);
      Begin
      Self.FDCTIPO := Value;
End;
      Procedure  TNFISCAL.SetCFOP          (Value : string);
      Begin
      Self.FCFOP := Value;
End;
      Procedure  TNFISCAL.SetVL_DOC        (Value : Double);
      Begin
      Self.FVL_DOC := Value;
End;
      Procedure  TNFISCAL.SetVL_DESC       (Value : Double);
      Begin
      Self.FVL_DESC := Value;
End;
      Procedure  TNFISCAL.SetVL_FORN       (Value : Double);
      Begin
      Self.FVL_FORN := Value;
End;
      Procedure  TNFISCAL.SetVL_SERV_NT    (Value : Double);
      Begin
      Self.FVL_SERV_NT := Value;
End;
      Procedure  TNFISCAL.SetVL_PIS   (Value : Double);
      Begin
      Self.FVL_PIS := Value;
End;
      Procedure  TNFISCAL.SetVL_TERC       (Value : Double);
      Begin
      Self.FVL_TERC := Value;
End;
      Procedure  TNFISCAL.SetVL_DA         (Value : Double);
      Begin
      Self.FVL_DA := Value;
End;
      Procedure  TNFISCAL.SetVL_BC_ICMS    (Value : Double);
      Begin
      Self.FVL_BC_ICMS := Value;
End;


      Procedure  TNFISCAL.SetVL_ICMS     (Value : Double);
      Begin
      Self.FVL_ICMS := Value;
End;
      Procedure  TNFISCAL.SetVL_BC_ICMS_ST (Value : Double);
      Begin
      Self.FVL_BC_ICMS_ST := Value;
End;
     { Procedure  TNFISCAL.SetVL_ICMS_ST (Value : Double);
      Begin
      Self.FVL_ICMS_ST := Value;
      End;  }

      Procedure  TNFISCAL.SetCOD_INF       (Value : Double);
      Begin
      Self.FCOD_INF := Value;
End;
      Procedure  TNFISCAL.SetVL_COFINS     (Value : Double);
      Begin
      Self.FVL_COFINS := Value;
End;
      Procedure  TNFISCAL.SetTP_LIGACAO    (Value : Double);
      Begin
      Self.FTP_LIGACAO := Value;
End;
      Procedure  TNFISCAL.SetIPI           (Value : Double);
      Begin
      Self.FIPI := Value;
End;
      Procedure  TNFISCAL.SetDTEMISSAO     (Value : TDateTime);
      Begin
      Self.FDTEMISSAO := Value;
End;
      Procedure  TNFISCAL.SetDTENTRADA     (Value : TDateTime);
      Begin
      Self.FdtENTRADA := Value;
End;
      Procedure  TNFISCAL.SetDTVENCIMENTO  (Value : TDateTime);
      Begin
      Self.FDTVENCIMENTO := Value;
End;

end.

