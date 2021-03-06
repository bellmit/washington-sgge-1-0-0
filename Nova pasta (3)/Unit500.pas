unit Unit500;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, ExtCtrls, ActCustomEdit, ActNumberEdit, ActResultEdit,
  ActEdit, ActCurrencyEdit, ActMask, ActDateEdit, DB, IBCustomDataSet,
  IBQuery, Buttons, IBUpdateSQL;

type
  TFrmCadTitulos = class(TForm)
    Panel1: TPanel;
    ActResultEdit1: TActResultEdit;
    Panel2: TPanel;
    ScrollBox1: TScrollBox;
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    TXTEMPRESA: TActResultEdit;
    TXTFILIAL: TActResultEdit;
    GroupBox3: TGroupBox;
    TXTNUMERO: TActNumberEdit;
    TXTSERIE: TActEdit;
    TXTTIPO: TActEdit;
    TXTORDEM: TActEdit;
    TXTPARCELA: TActNumberEdit;
    TXTFORNECEDOR: TActResultEdit;
    TXTDATATITULO: TActDateEdit;
    TXTVALOR: TActCurrencyEdit;
    TXTDATVENCI: TActDateEdit;
    TXTDATBAIXA: TActDateEdit;
    TXTVALORPAGO: TActCurrencyEdit;
    TXTCONTA: TActResultEdit;
    GroupBox4: TGroupBox;
    TXTTIPOTITULO: TActResultEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    QryEmp: TIBQuery;
    QryFil: TIBQuery;
    QryTipTi: TIBQuery;
    QryFor: TIBQuery;
    SpeedButton1: TSpeedButton;
    QryBaixa1: TIBQuery;
    QryBaixa2: TIBQuery;
    QryTiTULOS: TIBQuery;
    IBUpdateSQL1: TIBUpdateSQL;
    QryContaCorrente: TIBQuery;
    IBUpdateSQL2: TIBUpdateSQL;
    QryFornecedor: TIBQuery;
    SpeedButton2: TSpeedButton;
    SpeedButton3: TSpeedButton;
    SpeedButton4: TSpeedButton;
    SpeedButton5: TSpeedButton;
    SpeedButton6: TSpeedButton;
    SpeedButton7: TSpeedButton;
    SpeedButton8: TSpeedButton;
    SpeedButton9: TSpeedButton;
    SpeedButton10: TSpeedButton;
    SpeedButton11: TSpeedButton;
    GroupBox5: TGroupBox;
    RadioButton1: TRadioButton;
    RadioButton2: TRadioButton;
    QryTiTULOSDCNUMERO: TIntegerField;
    QryTiTULOSDCSERIE: TIBStringField;
    QryTiTULOSDCORDEM: TIBStringField;
    QryTiTULOSDCTIPO: TIBStringField;
    QryTiTULOSPARCELA: TFloatField;
    QryTiTULOSDTVENCIMENTO: TDateField;
    QryTiTULOSDTLANCAMENTO: TDateField;
    QryTiTULOSSTATUS: TIBStringField;
    QryTiTULOSTPSITUACAO: TIBStringField;
    QryTiTULOSVLPARCELA: TFloatField;
    QryTiTULOSFORNECEDOR: TFloatField;
    QryTiTULOSOBS: TIBStringField;
    QryTiTULOSDATAPAGAMENTO: TDateField;
    QryTiTULOSTIPO_TITULO: TIntegerField;
    QryTiTULOSCOD_EMPRESA: TIntegerField;
    QryTiTULOSCOD_FILIAL: TIntegerField;
    QryTiTULOSCOD_CONTA: TIntegerField;
    QryTiTULOSCOD_TITULO: TIntegerField;
    QryTiTULOSVALORPAGO: TFloatField;
    QryTiTULOSOPER_TITULO: TIBStringField;
    Memo1: TMemo;
    Label5: TLabel;
    IBUpdateSQL3: TIBUpdateSQL;
    IBQuery1: TIBQuery;
    IntegerField1: TIntegerField;
    IBStringField1: TIBStringField;
    IntegerField2: TIntegerField;
    IBStringField2: TIBStringField;
    IBStringField3: TIBStringField;
    IntegerField3: TIntegerField;
    DateTimeField1: TDateTimeField;
    IBStringField4: TIBStringField;
    IntegerField4: TIntegerField;
    IntegerField5: TIntegerField;
    IntegerField6: TIntegerField;
    IntegerField7: TIntegerField;
    FloatField1: TFloatField;
    IBStringField5: TIBStringField;
    FloatField2: TFloatField;
    FloatField3: TFloatField;
    IBStringField6: TIBStringField;
    IBStringField7: TIBStringField;
    IntegerField8: TIntegerField;
    IntegerField9: TIntegerField;
    DateTimeField2: TDateTimeField;
    IBStringField8: TIBStringField;
    FloatField4: TFloatField;
    IntegerField10: TIntegerField;
    IntegerField11: TIntegerField;
    IBStringField9: TIBStringField;
    IntegerField12: TIntegerField;
    IBStringField10: TIBStringField;
    IBStringField11: TIBStringField;
    ActNumberEdit1: TActNumberEdit;
    IBQuery2: TIBQuery;
    QryContaCorrenteNOBANCO: TIntegerField;
    QryContaCorrenteCDAGENCIA: TIBStringField;
    QryContaCorrenteNOCONTA: TIntegerField;
    QryContaCorrenteNMBANCO: TIBStringField;
    QryContaCorrenteNMAGENCIA: TIBStringField;
    QryContaCorrenteNOCOMPENSACAO: TIntegerField;
    QryContaCorrenteDTSALDO: TDateTimeField;
    QryContaCorrenteDSGRUPO: TIBStringField;
    QryContaCorrenteCDEMPRESA: TIntegerField;
    QryContaCorrenteCDFILIAL: TIntegerField;
    QryContaCorrenteCDCONTACORRENTE: TIntegerField;
    QryContaCorrenteNOTRADUTOR: TIntegerField;
    QryContaCorrenteSQNOSSONUMERO: TFloatField;
    QryContaCorrenteSNNOSSONUMAUTO: TIBStringField;
    QryContaCorrenteSQCHEQUES: TFloatField;
    QryContaCorrentePCJUROMES: TFloatField;
    QryContaCorrenteDSINSTRUCAO1: TIBStringField;
    QryContaCorrenteDSINSTRUCAO2: TIBStringField;
    QryContaCorrenteSQREMESSA: TIntegerField;
    QryContaCorrenteNOCONVENIO: TIntegerField;
    QryContaCorrenteDTULTALT: TDateTimeField;
    QryContaCorrenteUSULTALT: TIBStringField;
    QryContaCorrenteVLSALDO: TFloatField;
    QryContaCorrenteCDHISTORICO: TIntegerField;
    QryContaCorrenteCDHISTCTB: TIntegerField;
    QryContaCorrenteSNMOVBANCUNICO: TIBStringField;
    QryContaCorrenteCDTITULARNOMINAL: TIntegerField;
    QryContaCorrenteSTATUS: TIBStringField;
    QryContaCorrenteCARTEIRA: TIBStringField;
    procedure TXTEMPRESAChange(Sender: TObject);
    procedure TXTFILIALChange(Sender: TObject);
    procedure TXTTIPOTITULOChange(Sender: TObject);
    procedure SpeedButton1Click(Sender: TObject);
    procedure TXTFORNECEDORChange(Sender: TObject);
    procedure QryTiTULOSBeforeInsert(DataSet: TDataSet);
    procedure QryTiTULOSBeforeDelete(DataSet: TDataSet);
    procedure SpeedButton4Click(Sender: TObject);
    procedure SpeedButton3Click(Sender: TObject);
    procedure SpeedButton5Click(Sender: TObject);
    procedure SpeedButton8Click(Sender: TObject);
    procedure SpeedButton9Click(Sender: TObject);
    procedure SpeedButton6Click(Sender: TObject);
    procedure SpeedButton7Click(Sender: TObject);
    procedure SpeedButton2Click(Sender: TObject);
    procedure TXTTIPOTITULOExit(Sender: TObject);
    procedure FormActivate(Sender: TObject);
  private
    { Private declarations }        
  public
    function GravarBaixa(const cdtitulo:Integer ):Boolean;
    function GravarBaixaConta():Boolean;
    function Primeiro():Boolean;
    function Proximo():Boolean;
    function Anterior():Boolean;
    function Ultimo():Boolean;
    function GravarTitulo():Boolean;
    function AlterarTitulo():Boolean;
    function ExcluirTitulo():Boolean;
    function PopularTXT():Boolean;
    function PopularBanco():Boolean;
    function PopularSelectInicial():Boolean;
    function GravarALMENTOConta(CONST VALOR :DOUBLE;CONTA :INTEGER ):Boolean;
  end;

var
  FrmCadTitulos: TFrmCadTitulos;

implementation

uses Unit1;

{$R *.dfm}

    function TFrmCadTitulos.GravarTitulo():Boolean;
    begin
      QryTiTULOS.Active := False;
      QryTiTULOS.SQL.Clear;
      QryTiTULOS.SQL.Add('      insert into titulospagar2 ');
      QryTiTULOS.SQL.Add('  (DCNUMERO, DCSERIE, DCORDEM, DCTIPO, PARCELA, DTVENCIMENTO, DTLANCAMENTO, ');
      QryTiTULOS.SQL.Add('   STATUS, TPSITUACAO, VLPARCELA, FORNECEDOR, OBS, TIPO_TITULO, ');
      QryTiTULOS.SQL.Add('   COD_EMPRESA, COD_FILIAL, COD_TITULO, VALORPAGO, OPER_TITULO,NOCHEQUE)');
      QryTiTULOS.SQL.Add('values');
      QryTiTULOS.SQL.Add('  (:DCNUMERO, :DCSERIE, :DCORDEM, :DCTIPO, :PARCELA, :DTVENCIMENTO, :DTLANCAMENTO, ');
      QryTiTULOS.SQL.Add('   :STATUS, :TPSITUACAO, :VLPARCELA, :FORNECEDOR, :OBS, ');
      QryTiTULOS.SQL.Add('   :TIPO_TITULO, :COD_EMPRESA, :COD_FILIAL, :COD_TITULO, :VALORPAGO,');
      QryTiTULOS.SQL.Add('   :OPER_TITULO,:NOCHEQUE)');
     IF(RadioButton1.Checked = tRUE )THEN
       QryTiTULOS.ParamByName('STATUS').AsString       := 'D'
     ELSE
       QryTiTULOS.ParamByName('STATUS').AsString       := 'A';
     QryTiTULOS.ParamByName('TPSITUACAO').AsString   := 'F';
     QryTiTULOS.ParamByName('Cod_empresa').asInteger :=  StrToInt(TXTEMPRESA.Text);
     QryTiTULOS.ParamByName('Cod_filial').asInteger  :=  StrToInt(TXTFILIAL.Text);
     QryTiTULOS.ParamByName('dcnumero').asInteger    :=  StrToInt(TXTNUMERO.Text);
     QryTiTULOS.ParamByName('dcserie').AsString      :=   TXTSERIE.Text;
     QryTiTULOS.ParamByName('dctipo').AsString       :=   TXTTIPO.Text;
     QryTiTULOS.ParamByName('dcordem').AsString      :=   TXTORDEM.Text;
     QryTiTULOS.ParamByName('parcela').asInteger     :=  StrToInt(TXTPARCELA.Text);
     QryTiTULOS.ParamByName('fornecedor').asInteger  :=  StrToInt(TXTFORNECEDOR.Text);
     QryTiTULOS.ParamByName('dtlancamento').asdATETIME := StrToDate(TXTDATATITULO.Text);
     QryTiTULOS.ParamByName('vlparcela').asfLOAT       := StrToFloat(TXTVALOR.Text);
     QryTiTULOS.ParamByName('dtvencimento').asdATETIME :=   StrToDate(TXTDATVENCI.Text);
    // QryTiTULOS.ParamByName('datapagamento').asdATETIME:=   StrToDate(TXTDATBAIXA.Text);
     QryTiTULOS.ParamByName('valorpago').asfLOAT       :=   StrToFloat(TXTVALORPAGO.Text);
    // QryTiTULOS.ParamByName('cod_conta').asInteger     :=   StrToInt(TXTCONTA.Text);
     QryTiTULOS.ParamByName('tipo_titulo').asInteger   :=   StrToInt(TXTTIPOTITULO.Text);
     QryTiTULOS.ParamByName('COD_TITULO').asInteger    :=   StrToInt(ActResultEdit1.Text);
        if(RadioButton1.Checked = True  )then
           QryTiTULOS.ParamByName('OPER_TITULO').AsString := 'P'
        else
           QryTiTULOS.ParamByName('OPER_TITULO').AsString := 'R';
     QryTiTULOS.ParamByName('OBS').AsString :=   MEMO1.Lines.Text;
     QryTiTULOS.ParamByName('NOCHEQUE').asInteger    :=   StrToInt(ActNumberEdit1.Text);
     try
     QryTiTULOS.ExecSQL;
     QryTiTULOS.Transaction.Commit;
     result := True;
     Except
     result := False;
     end;

    end;
    function TFrmCadTitulos.AlterarTitulo():Boolean;
    begin
            QryTiTULOS.Active := False;
      QryTiTULOS.SQL.Clear;
     QryTiTULOS.SQL.Add('    update titulospagar2 ');
     QryTiTULOS.SQL.Add(' set  ');
     QryTiTULOS.SQL.Add(' DCNUMERO = :DCNUMERO,');
     QryTiTULOS.SQL.Add(' DCSERIE = :DCSERIE,');
     QryTiTULOS.SQL.Add(' DCORDEM = :DCORDEM, ');
     QryTiTULOS.SQL.Add(' DCTIPO = :DCTIPO, ');
     QryTiTULOS.SQL.Add(' PARCELA = :PARCELA, ');
     QryTiTULOS.SQL.Add(' DTVENCIMENTO = :DTVENCIMENTO,');
     QryTiTULOS.SQL.Add(' DTLANCAMENTO = :DTLANCAMENTO, ');
     QryTiTULOS.SQL.Add(' STATUS = :STATUS,');
     QryTiTULOS.SQL.Add(' TPSITUACAO = :TPSITUACAO,');
     QryTiTULOS.SQL.Add(' VLPARCELA = :VLPARCELA,');
     QryTiTULOS.SQL.Add(' FORNECEDOR = :FORNECEDOR,');
     QryTiTULOS.SQL.Add(' OBS = :OBS,');
     QryTiTULOS.SQL.Add(' DATAPAGAMENTO = :DATAPAGAMENTO,');
     QryTiTULOS.SQL.Add(' TIPO_TITULO = :TIPO_TITULO, ');
     QryTiTULOS.SQL.Add(' COD_EMPRESA = :COD_EMPRESA, ');
     QryTiTULOS.SQL.Add(' COD_FILIAL = :COD_FILIAL, ');
     QryTiTULOS.SQL.Add(' COD_CONTA = :COD_CONTA,  ');
     QryTiTULOS.SQL.Add(' COD_TITULO = :COD_TITULO, ');
     QryTiTULOS.SQL.Add(' VALORPAGO = :VALORPAGO,    ');
     QryTiTULOS.SQL.Add('  OPER_TITULO = :OPER_TITULO  ');
     QryTiTULOS.SQL.Add('NOCHEQUE = :NOCHEQUE  ');
     QryTiTULOS.SQL.Add(' where ');
     QryTiTULOS.SQL.Add('COD_TITULO :oLD_COD_TITULO AND ');
     QryTiTULOS.SQL.Add('PARCELA = :old_PARCELA and ');
     QryTiTULOS.SQL.Add('COD_EMPRESA = :OLD_COD_EMPRESA and  ');
     QryTiTULOS.SQL.Add('COD_FILIAL = :OLD_COD_FILIAL  ');
     QryTiTULOS.ParamByName('Cod_empresa').asInteger :=  StrToInt(TXTEMPRESA.Text);
     QryTiTULOS.ParamByName('Cod_filial').asInteger  :=  StrToInt(TXTFILIAL.Text);
     QryTiTULOS.ParamByName('dcnumero').asInteger    :=  StrToInt(TXTNUMERO.Text);
     QryTiTULOS.ParamByName('dcserie').AsString      :=   TXTSERIE.Text;
     QryTiTULOS.ParamByName('dctipo').AsString       :=   TXTTIPO.Text;
     QryTiTULOS.ParamByName('dcordem').AsString      :=   TXTORDEM.Text;
     QryTiTULOS.ParamByName('parcela').asInteger     :=  StrToInt(TXTPARCELA.Text);
     QryTiTULOS.ParamByName('fornecedor').asInteger  :=  StrToInt(TXTFORNECEDOR.Text);
     QryTiTULOS.ParamByName('dtlancamento').asdATETIME := StrToDate(TXTDATATITULO.Text);
     QryTiTULOS.ParamByName('vlparcela').asfLOAT       := StrToFloat(TXTVALOR.Text);
     QryTiTULOS.ParamByName('dtvencimento').asdATETIME :=   StrToDate(TXTDATVENCI.Text);
     QryTiTULOS.ParamByName('datapagamento').asdATETIME:=   StrToDate(TXTDATBAIXA.Text);
     QryTiTULOS.ParamByName('valorpago').asfLOAT       :=   StrToFloat(TXTVALORPAGO.Text);
     QryTiTULOS.ParamByName('cod_conta').asInteger     :=   StrToInt(TXTCONTA.Text);
     QryTiTULOS.ParamByName('tipo_titulo').asInteger   :=   StrToInt(TXTTIPOTITULO.Text);
     QryTiTULOS.ParamByName('COD_TITULO').asInteger    :=   StrToInt(ActResultEdit1.Text);
     QryTiTULOS.ParamByName('OLD_COD_TITULO').asInteger    :=   StrToInt(ActResultEdit1.Text);
     QryTiTULOS.ParamByName('OLD_parcela').asInteger     :=  StrToInt(TXTPARCELA.Text);
     QryTiTULOS.ParamByName('OLD_COD_EMPRESA').asInteger :=  StrToInt(TXTEMPRESA.Text);
     QryTiTULOS.ParamByName('OLD_COD_FILIAL').asInteger  :=  StrToInt(TXTFILIAL.Text);
     QryTiTULOS.ParamByName('NOCHEQUE').asInteger    :=   StrToInt(ActNumberEdit1.Text);
        if(RadioButton1.Checked = True  )then
           QryTiTULOS.ParamByName('OPER_TITULO').AsString := 'P'
        else
           QryTiTULOS.ParamByName('OPER_TITULO').AsString := 'R';
     QryTiTULOS.ParamByName('OBS').AsString :=   MEMO1.Lines.Text;
     TRY
       QryTiTULOS.ExecSQL;
       QryTiTULOS.Transaction.Commit;
       RESULT := TRUE;
     Except
       RESULT := FALSE;
     END;
    end;
    function TFrmCadTitulos.ExcluirTitulo():Boolean;
    begin
    QryTiTULOS.SQL.Clear;
    QryTiTULOS.Active := fALSE;
    QryTiTULOS.SQL.Add('select *from titulospagar2 where cod_titulo ='+ActResultEdit1.Text);
    QryTiTULOS.Active := tRUE ;

             QryTiTULOS.Active := False;
             QryTiTULOS.SQL.Clear;
             QryTiTULOS.SQL.Add('UPDATE  TITULOSPAGAR2 SET STATUS = :STATUS,TPSITUACAO = :TPSITUACAO WHERE ');
             QryTiTULOS.ParamByName('STATUS').AsString       := 'E';
             QryTiTULOS.ParamByName('TPSITUACAO').AsString   := 'C';
             QryTiTULOS.SQL.Add('COD_TITULO =  :oLD_COD_TITULO AND ');
             QryTiTULOS.SQL.Add('PARCELA = :old_PARCELA and ');
             QryTiTULOS.SQL.Add('COD_EMPRESA = :OLD_COD_EMPRESA and  ');
             QryTiTULOS.SQL.Add('COD_FILIAL = :OLD_COD_FILIAL  ');
     TRY
     QryTiTULOS.ParamByName('OLD_COD_TITULO').asInteger  :=  StrToInt(ActResultEdit1.Text);
     QryTiTULOS.ParamByName('OLD_Cod_empresa').asInteger :=  StrToInt(TXTEMPRESA.Text);
     QryTiTULOS.ParamByName('OLD_Cod_filial').asInteger  :=  StrToInt(TXTFILIAL.Text);
     QryTiTULOS.ParamByName('OLD_parcela').asInteger     :=  StrToInt(TXTPARCELA.Text);
     QryTiTULOS.ExecSQL;
     QryTiTULOS.Transaction.Commit;
     RESULT := TRUE;
     Except
     RESULT := FALSE;
     END;







    end;
    function TFrmCadTitulos.Primeiro():Boolean;
    begin
      IBQuery2.First;
    end;
    function TFrmCadTitulos.Proximo():Boolean;
    begin
       IBQuery2.Next;
    end;
    function TFrmCadTitulos.Anterior():Boolean;
    begin
       IBQuery2.Prior;
    end;
    function TFrmCadTitulos.Ultimo():Boolean;
    begin
       IBQuery2.Last;
    end;


    function TFrmCadTitulos.PopularSelectInicial():Boolean;
    begin
     IBQuery2.SQL.Clear();
     IBQuery2.Active := False;
     IBQuery2.SQL.Text := 'Select *from titulospagar2 WHERE STATUS <> ''E''  order by cod_titulo';
     IBQuery2.Active := True;

    end;
    function TFrmCadTitulos.PopularTXT():Boolean;
    begin
       TXTEMPRESA.Text :=      IntToStr(QryTiTULOS.FieldByName('Cod_empresa').asInteger);
       TXTFILIAL.Text :=       IntToStr(QryTiTULOS.FieldByName('Cod_filial').asInteger);
       TXTNUMERO.Text :=       IntToStr(QryTiTULOS.FieldByName('dcnumero').asInteger);
       TXTSERIE.Text :=        QryTiTULOS.FieldByName('dcserie').AsString;
       TXTTIPO.Text :=         QryTiTULOS.FieldByName('dctipo').AsString;
       TXTORDEM.Text :=        QryTiTULOS.FieldByName('dcordem').AsString;
       TXTPARCELA.Text :=      IntToStr(QryTiTULOS.FieldByName('parcela').asInteger);
       TXTFORNECEDOR.Text :=   IntToStr(QryTiTULOS.FieldByName('fornecedor').asInteger);
       TXTDATATITULO.Text :=   DateToStr(QryTiTULOS.FieldByName('dtlancamento').asdATETIME);
       TXTVALOR.Text :=        FloatToStr(QryTiTULOS.FieldByName('vlparcela').asfLOAT);
       TXTDATVENCI.Text :=     DateToStr(QryTiTULOS.FieldByName('dtvencimento').asdATETIME);
       TXTDATBAIXA.Text :=     DateToStr(QryTiTULOS.FieldByName('datapagamento').asdATETIME);
       TXTVALORPAGO.Text :=    FloatToStr(QryTiTULOS.FieldByName('valorpago').asfLOAT);
       TXTCONTA.Text :=        IntToStr(QryTiTULOS.FieldByName('cod_conta').asInteger);
       TXTTIPOTITULO.Text :=   IntToStr(QryTiTULOS.FieldByName('tipo_titulo').asInteger);
       ActResultEdit1.Text :=  IntToStr(QryTiTULOS.FieldByName('COD_TITULO').asInteger);
        if(QryTiTULOS.FieldByName('OPER_TITULO').AsString = 'P')then
           RadioButton1.Checked := True
        else
           RadioButton2.Checked := True;
       MEMO1.Lines.Text := QryTiTULOS.FieldByName('OBS').AsString;

    end;
    function TFrmCadTitulos.PopularBanco():Boolean;
    begin

     QryTiTULOS.FieldByName('Cod_empresa').asInteger :=  StrToInt(TXTEMPRESA.Text);
     QryTiTULOS.FieldByName('Cod_filial').asInteger  :=  StrToInt(TXTFILIAL.Text);
     QryTiTULOS.FieldByName('dcnumero').asInteger    :=  StrToInt(TXTNUMERO.Text);
     QryTiTULOS.FieldByName('dcserie').AsString      :=   TXTSERIE.Text;
     QryTiTULOS.FieldByName('dctipo').AsString       :=   TXTTIPO.Text;
     QryTiTULOS.FieldByName('dcordem').AsString      :=   TXTORDEM.Text;
     QryTiTULOS.FieldByName('parcela').asInteger     :=  StrToInt(TXTPARCELA.Text);
     QryTiTULOS.FieldByName('fornecedor').asInteger  :=  StrToInt(TXTFORNECEDOR.Text);
     QryTiTULOS.FieldByName('dtlancamento').asdATETIME := StrToDate(TXTDATATITULO.Text);
     QryTiTULOS.FieldByName('vlparcela').asfLOAT       := StrToFloat(TXTVALOR.Text);
     QryTiTULOS.FieldByName('dtvencimento').asdATETIME :=   StrToDate(TXTDATVENCI.Text);
     QryTiTULOS.FieldByName('datapagamento').asdATETIME:=   StrToDate(TXTDATBAIXA.Text);
     QryTiTULOS.FieldByName('valorpago').asfLOAT       :=   StrToFloat(TXTVALORPAGO.Text);
     QryTiTULOS.FieldByName('cod_conta').asInteger     :=   StrToInt(TXTCONTA.Text);
     QryTiTULOS.FieldByName('tipo_titulo').asInteger   :=   StrToInt(TXTTIPOTITULO.Text);
     QryTiTULOS.FieldByName('COD_TITULO').asInteger    :=   StrToInt(ActResultEdit1.Text);
        if(RadioButton1.Checked = True  )then
           QryTiTULOS.FieldByName('OPER_TITULO').AsString := 'P'
        else
           QryTiTULOS.FieldByName('OPER_TITULO').AsString := 'R';
     QryTiTULOS.FieldByName('OBS').AsString :=   MEMO1.Lines.Text;



    end;




 function TFrmCadTitulos.GravarALMENTOConta(CONST VALOR :DOUBLE;CONTA :INTEGER ):Boolean;
 begin
   QryContaCorrente.Active := False;
   QryContaCorrente.SQL.Clear;
   QryContaCorrente.SQL.Add('update contacorrente set vlsaldo = vlsaldo +'+FloatToStr(VALOR)+' where cdcontacorrente = '+IntToStr(CONTA)+'' );
   QryContaCorrente.ExecSQL;
   QryContaCorrente.Transaction.Commit;
 end;

 function TFrmCadTitulos.GravarBaixaConta():Boolean;
 var RESP_PAG :INTEGER;
 begin
   RESP_PAG := 1;
   TRY
   QryContaCorrente.Active := False;
   QryContaCorrente.SQL.Clear;
   QryContaCorrente.SQL.Add('update contacorrente set vlsaldo = vlsaldo -'+TXTVALORPAGO.Text+',DATA_PAG = '''+DateToStr(now)+''',RESP_PAG = '+IntToStr(RESP_PAG)+' where cdcontacorrente = '+TXTCONTA.Text+'' );
   QryContaCorrente.ExecSQL;
   QryContaCorrente.Transaction.Commit;
   result   := True;
   Except
     Result := false;
   end;
 end;
function TFrmCadTitulos.GravarBaixa(const cdtitulo:Integer ):Boolean;
begin
  QryTiTULOS.SQL.Clear;
 QryTiTULOS.SQL.Add(' update titulospagar2 set          ');
 QryTiTULOS.SQL.Add('            COD_CONTA = :COD_CONTA,');
 QryTiTULOS.SQL.Add('            DATAPAGAMENTO = :DATAPAGAMENTO,');
 QryTiTULOS.SQL.Add('            VALORPAGO= :VALORPAGO,');
 QryTiTULOS.SQL.Add('            STATUS= :STATUS ');
 QryTiTULOS.SQL.Add(' WHERE COD_TITULO= :COD_TITULO ');

 QryTiTULOS.ParamByName('COD_CONTA').AsInteger := StrToInt(TXTCONTA.Text);
 QryTiTULOS.ParamByName('DATAPAGAMENTO').AsDateTime := StrToDate(TXTDATBAIXA.Text);
 QryTiTULOS.ParamByName('VALORPAGO').AsFloat :=      StrToFloat(TXTVALORPAGO.Text);
 QryTiTULOS.ParamByName('STATUS').AsString :=        'B';
 QryTiTULOS.ParamByName('COD_TITULO').AsInteger :=   StrToInt(ActResultEdit1.Text);
 TRY
 QryTiTULOS.ExecSQL;
 QryTiTULOS.Transaction.Commit;
 RESULT  := tRUE;
 Except
   RESULT := FALSE;
 END
end;
procedure TFrmCadTitulos.TXTEMPRESAChange(Sender: TObject);
begin
  if (TXTEMPRESA.Text <> '')then
  begin

  QryEmp.Active := False;
  QryEmp.ParamByName('Cod_Empresa').AsInteger := StrToInt(txtempresa.Text);
  QryEmp.Active := True;
  if(not QryEmp.Eof)then
     Label1.Caption := ''+QryEmp.fieldbyName('nome').AsString
  else
     Label1.Caption := '';
  end;
end;

procedure TFrmCadTitulos.TXTFILIALChange(Sender: TObject);
begin
  if (txtfilial.Text <> '')then
  begin
  Qryfil.Active := False;
  Qryfil.ParamByName('CdFilial').AsInteger := StrToInt(txtFilial.Text);
  Qryfil.ParamByName('Cod_Empresa').AsInteger := StrToInt(txtempresa.Text);
  Qryfil.Active := True;
  if(not Qryfil.Eof)then
     Label2.Caption := Qryfil.fieldbyName('NOME').AsString
  else
     Label2.Caption := '';
  end;
end;

procedure TFrmCadTitulos.TXTTIPOTITULOChange(Sender: TObject);
begin
   if (TXTTIPOTITULO.Text <> '')then
  begin
  QryTipTi.Active := False;
  QryTipTi.ParamByName('TipoTitulo').AsInteger := StrToInt(TXTTIPOTITULO.Text);
  QryTipTi.Active := True;
  if(not QryTipTi.Eof)then
     Label3.Caption := QryTipTi.fieldbyName('DStipotitulo').AsString
  else
     Label3.Caption := '';
   IF (TXTTIPOTITULO.Text = '8')THEN
     ActNumberEdit1.Visible := tRUE
   ELSE
    ActNumberEdit1.Visible := fALSE;


  end;

end;

procedure TFrmCadTitulos.SpeedButton1Click(Sender: TObject);
begin
 QryTiTULOS.SQL.Clear;
 QryTiTULOS.Active := fALSE;
 QryTiTULOS.SQL.Add('select *from titulospagar2 where cod_titulo ='+ActResultEdit1.Text);
 QryTiTULOS.Active := tRUE ;
 if(QryTiTULOS.FieldByName('STATUS').AsString <> 'B'  ) then
 begin
 if(QryTiTULOS.FieldByName('STATUS').AsString <> 'D'  ) then
  begin
  IF ((TXTCONTA.Text <> '' ) OR (TXTCONTA.Text <> ' ')) THEN
   BEGIN
    QryBaixa1.Active := False;
    QryBaixa1.ParamByName('CDCONTACORRENTE').AsInteger := StrToInt(TXTCONTA.Text);
    QryBaixa1.Active := True;
    if (not QryBaixa1.Eof )then
       IF(GravarBaixa(StrToInt(ActResultEdit1.Text)) = tRUE )THEN
         SHOWMESSAGE('BAIXA EFETUADA COM SUCESSO')
       ELSE
         SHOWMESSAGE('ERRO AO FAZER A BAIXA')
    else
    ShowMessage('Conta nao cadastrada');
    end
    ELSE
   ShowMessage('Favor prencher o numero da conta para baixa');
   end
   else
       ShowMEssage('BAIXA N�O FOI AUTORIZADA PAGAMENTO NAO APROVADO');
  end
  else ShowMEssage('TITULO JA BAIXADO');
 end;
procedure TFrmCadTitulos.TXTFORNECEDORChange(Sender: TObject);
begin
  if (TXTFORNECEDOR.Text <> '')then
  begin

  QryFor.Active := False;
  QryFor.ParamByName('CodPart').AsInteger := StrToInt(TXTFORNECEDOR.Text);
  QryFor.Active := True;
  if(not QryFor.Eof)then
     Label4.Caption := ''+QryFor.fieldbyName('nome').AsString
  else
     Label4.Caption := '';
  end;

end;





procedure TFrmCadTitulos.QryTiTULOSBeforeInsert(DataSet: TDataSet);
begin
ShowMEssage('BeforeInsert');
end;

procedure TFrmCadTitulos.QryTiTULOSBeforeDelete(DataSet: TDataSet);
begin
ShowMEssage('BeforeDelete');
end;

procedure TFrmCadTitulos.SpeedButton4Click(Sender: TObject);
begin
 if (GravarTitulo() = True) then
     ShowMessage('TITULO CADASTRADO COM SUCESSO')
 else
     ShowMessage('ERRO NO CADASTRO DO TITULO ' );
end;

procedure TFrmCadTitulos.SpeedButton3Click(Sender: TObject);
begin
   if (AlterarTitulo()= True) then
     ShowMessage('TITULO CADASTRADO COM SUCESSO')
   else
     ShowMessage('ERRO NO CADASTRO DO TITULO ' );
end;

procedure TFrmCadTitulos.SpeedButton5Click(Sender: TObject);
begin
  if MessageDlg('DESEJA REALMENTE EXCLUIR TITULO ', mtConfirmation, [mbYes, mbNo], 0) = mrYes then
  BEGIN
     if (ExcluirTitulo()= True) then
       ShowMessage('TITULO CADASTRADO COM SUCESSO')
     else
      ShowMessage('ERRO NO CADASTRO DO TITULO ' );
  END;
end;

procedure TFrmCadTitulos.SpeedButton8Click(Sender: TObject);
begin
Primeiro();
PopularTXT();
end;

procedure TFrmCadTitulos.SpeedButton9Click(Sender: TObject);
begin
ULTIMO();
PopularTXT();
end;

procedure TFrmCadTitulos.SpeedButton6Click(Sender: TObject);
begin
Proximo();
PopularTXT();
end;

procedure TFrmCadTitulos.SpeedButton7Click(Sender: TObject);
begin
Anterior();
PopularTXT();
end;

procedure TFrmCadTitulos.SpeedButton2Click(Sender: TObject);
begin
       TXTEMPRESA.Text :=      '';
       TXTFILIAL.Text :=       '';
       TXTNUMERO.Text :=       '';
       TXTSERIE.Text :=        '';
       TXTTIPO.Text :=         '';
       TXTORDEM.Text :=        '';
       TXTPARCELA.Text :=      '';
       TXTFORNECEDOR.Text :=   '';
       TXTDATATITULO.Text :=   '';
       TXTVALOR.Text :=        '';
       TXTDATVENCI.Text :=     '';
       TXTDATBAIXA.Text :=     '';
       TXTVALORPAGO.Text :=    '';
       TXTCONTA.Text :=        '';
       TXTTIPOTITULO.Text :=   '';
       ActResultEdit1.Text :=  '';
       RadioButton1.Checked := fALSE;
       RadioButton2.Checked := FALSE;
       MEMO1.Lines.Clear;
end;

procedure TFrmCadTitulos.TXTTIPOTITULOExit(Sender: TObject);
begin
IF (TXTTIPOTITULO.Text = '8')THEN
 ActNumberEdit1.Visible := tRUE
ELSE
 ActNumberEdit1.Visible := fALSE;
end;

procedure TFrmCadTitulos.FormActivate(Sender: TObject);
begin
PopularSelectInicial();
end;

end.
