unit Unit11;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Unit2, DB, IBCustomDataSet, IBQuery, Buttons, ExtCtrls,
  IBUpdateSQL, ActCurrencyEdit, ActMask, ActDateEdit, StdCtrls,
  ActCustomEdit, ActNumberEdit;

type
  TModeloForm11 = class(TModeloForm)
    IBQuery1: TIBQuery;
    IBQuery1ID: TIntegerField;
    IBQuery1DATAMOVIMENTO: TDateField;
    IBQuery1TOTAL: TFloatField;
    IBQuery1DINHEIRO: TFloatField;
    IBQuery1CHEQUE: TFloatField;
    IBQuery1CARTAO_CREDITO: TFloatField;
    IBQuery1CARTAO_DEBITO: TFloatField;
    IBQuery1PROMISSORIA: TFloatField;
    Label1: TLabel;
    DataSource1: TDataSource;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    Label8: TLabel;
    TXTID: TActNumberEdit;
    TXTDTMOVIMENTO: TActDateEdit;
    TXTTOTAL: TActCurrencyEdit;
    TXTDINHEIRO: TActCurrencyEdit;
    TXTCHEQUE: TActCurrencyEdit;
    TXTCREDITO: TActCurrencyEdit;
    TXTDEBITO: TActCurrencyEdit;
    TXTPROMISSORIA: TActCurrencyEdit;
    IBQInsertUpDel: TIBQuery;
    IBQInicial: TIBQuery;
    IBUpdateSQL1: TIBUpdateSQL;
    IBQuery2: TIBQuery;
    IBQuery3: TIBQuery;
    SpeedButton11: TSpeedButton;
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    Label9: TLabel;
    Label10: TLabel;
    IBQuery4: TIBQuery;
    GroupBox3: TGroupBox;
    Label11: TLabel;
    procedure FormCreate(Sender: TObject);
    procedure SpeedButton7Click(Sender: TObject);
    procedure SpeedButton8Click(Sender: TObject);
    procedure SpeedButton5Click(Sender: TObject);
    procedure SpeedButton6Click(Sender: TObject);
    procedure SpeedButton1Click(Sender: TObject);
    procedure SpeedButton3Click(Sender: TObject);
    procedure SpeedButton2Click(Sender: TObject);
    procedure SpeedButton4Click(Sender: TObject);
    procedure SpeedButton9Click(Sender: TObject);
    procedure SpeedButton11Click(Sender: TObject);
  private
    { Private declarations }
  public
    Function Insert():boolean;
    Function Altera():boolean;
    Function Deleta():boolean;
    Function Busca():boolean;
    Function Proximo():boolean;
    Function Anterior():boolean;
    Function Primeiro():boolean;
    Function Ultimo():boolean;
    Function SelectInicial():boolean;
    Function PopulaTxt():boolean;
    Function Buscard():Double;
    Function Limpa():Boolean;
    Function SomaItens(const DtMovimento :String):double;
    Function SomaReducao(const DtMovimento :String):Double;
  end;

var
  ModeloForm11: TModeloForm11;



implementation

uses Unit3, Unit8, Unit12;

{$R *.dfm}
Function TModeloForm11.SomaReducao(const DtMovimento :String):Double;
begin
  IBQuery4.Active := False;
  IBQuery4.SQL.Text := 'select *from redleitura r where r.dtmovimento = '''+Form7.ajustaData(TXTDTMOVIMENTO.Text)+'''';
  IBQuery4.Active := True;
  result := IBQuery4.FieldByName('VENDABRUTA').AsFloat;
end;


Function TModeloForm11.SomaItens(const DtMovimento :String):double;
begin
  IBQuery4.Active := False;
  IBQuery4.SQL.Text := 'select sum (i.quantidade * i.vlproduto) from nfsaidas2 n,nfsaidasitens i where i.coo = n.coo and n.dtmovimento = '''+Form7.ajustaData(TXTDTMOVIMENTO.Text)+'''  ';
  IBQuery4.Active := True;
  result := IBQuery4.FieldByName('Sum').AsFloat;
end;

    Function TModeloForm11.Limpa():Boolean;
    begin
      TXTID.Text := '';
      TXTDTMOVIMENTO.Text := '';
      TXTTOTAL.Text := '';
      TXTDINHEIRO.Text := '';
      TXTCHEQUE.Text := '';
      TXTCREDITO.Text := '';
      TXTDEBITO.Text := '';
      TXTPROMISSORIA.Text := '';
      result := True
    end;


    Function TModeloForm11.PopulaTxt():boolean;
    begin
        TXTID.Text := IntToStr(IBQInicial.FieldByName('ID').asInteger);
        TXTDTMOVIMENTO.Text := DateTimeToStr(IBQInicial.FieldByName('DaTaMOVIMENTO').asDateTime);
        TXTTOTAL.Text := FloatToStr(IBQInicial.FieldByName('TOTAL').AsFloat);
        TXTDINHEIRO.Text := FloatToStr(IBQInicial.FieldByName('DINHEIRO').AsFloat);
        TXTCHEQUE.Text := FloatToStr(IBQInicial.FieldByName('CHEQUE').AsFloat);
        TXTCREDITO.Text := FloatToStr(IBQInicial.FieldByName('cartao_CREDITO').AsFloat);
        TXTDEBITO.Text := FloatToStr(IBQInicial.FieldByName('cartao_DEBITO').AsFloat);
        TXTPROMISSORIA.Text := FloatToStr(IBQInicial.FieldByName('PROMISSORIA').AsFloat);
        Label9.Caption :=   FloatToStr(SomaItens(TXTDTMOVIMENTO.Text));
        Label10.Caption :=  FloatToStr(SomaReducao(TXTDTMOVIMENTO.Text));
        Label11.Caption :=  FloatToStr((IBQInicial.FieldByName('TOTAL').AsFloat -  SomaReducao(TXTDTMOVIMENTO.Text)));
        result := true;
    end;

    Function TModeloForm11.Insert():boolean;
    begin
      IBQInsertUpDel.SQL.Text := 'insert into movimentodiario (DATAMOVIMENTO, TOTAL, DINHEIRO, CHEQUE, CARTAO_CREDITO,CARTAO_DEBITO,PROMISSORIA) values('''+FORM7.ajustaData(TXTDTMOVIMENTO.Text)+''','+FORM7.ajustaVirgula(TXTTOTAL.Text)+','+FORM7.ajustaVirgula(TXTDINHEIRO.Text)+','+FORM7.ajustaVirgula(TXTCHEQUE.Text)+','+FORM7.ajustaVirgula(TXTCREDITO.Text)+','+FORM7.ajustaVirgula(TXTDEBITO.Text)+','+FORM7.ajustaVirgula(TXTPROMISSORIA.Text)+')';
      ShowMEssage(IBQInsertUpDel.SQL.Text);
      IBQInsertUpDel.ExecSQL;
      IBQInsertUpDel.Transaction.Commit;
      result := True;
    end;
    Function TModeloForm11.Altera():boolean;
    begin
      IBQInsertUpDel.SQL.Clear;
      IBQInsertUpDel.SQL.Add ('update movimentodiario');
      IBQInsertUpDel.SQL.Add ('set');
      IBQInsertUpDel.SQL.Add ('  DATAMOVIMENTO = '''+FORM7.ajustaData(TXTDTMOVIMENTO.Text)+''',');
      IBQInsertUpDel.SQL.Add ('  TOTAL = '+FORM7.ajustaVirgula(TXTTOTAL.Text)+',');
      IBQInsertUpDel.SQL.Add ('  DINHEIRO = '+FORM7.ajustaVirgula(TXTDINHEIRO.Text)+',');
      IBQInsertUpDel.SQL.Add ('  CHEQUE = '+FORM7.ajustaVirgula(TXTCHEQUE.Text)+',');
      IBQInsertUpDel.SQL.Add ('  CARTAO_CREDITO = '+FORM7.ajustaVirgula(TXTCREDITO.Text)+',');
      IBQInsertUpDel.SQL.Add (' CARTAO_DEBITO = '+FORM7.ajustaVirgula(TXTDEBITO.Text)+',');
      IBQInsertUpDel.SQL.Add ('  PROMISSORIA = '+FORM7.ajustaVirgula(TXTPROMISSORIA.Text)+'');
      IBQInsertUpDel.SQL.Add ('where');
      IBQInsertUpDel.SQL.Add ('  ID = '+TXTID.Text+'');
      IBQInsertUpDel.ExecSQL;
      IBQInsertUpDel.Transaction.Commit;
      result := True;
    end;
    Function TModeloForm11.Deleta():boolean;
    begin
      IBQInsertUpDel.SQL.Text := 'delete from movimentodiario where  ID = '''+TXTID.Text+'''';
      IBQInsertUpDel.ExecSQL;
      IBQInsertUpDel.Transaction.Commit;
      result := True;
    end;
    Function TModeloForm11.Busca():boolean;
    begin
      IBQInicial.Active := False;
      IBQInicial.SQL.Clear;
      IBQInicial.SQL.Add('select *from movimentodiario where id > 0') ;
      if(TXTID.Text <> '')then
          IBQInicial.SQL.Add(' and ID =  '+TXTID.Text+'') ;

      if(TXTDTMOVIMENTO.Text <> '')then
          IBQInicial.SQL.Add(' and datamovimento =  '''+FORM7.ajustaData(TXTDTMOVIMENTO.Text)+'''') ;
      if(TXTTOTAL.Text <> '')then
          IBQInicial.SQL.Add(' and total = '+FORM7.ajustaVirgula(TXTDTMOVIMENTO.Text)+'  ') ;
      if(TXTDINHEIRO.Text <> '')then
          IBQInicial.SQL.Add(' and dinheiro = '+FORM7.ajustaVirgula(TXTDINHEIRO.Text)+' ') ;
      if(TXTCHEQUE.Text <> '')then
          IBQInicial.SQL.Add('and cheque = '+FORM7.ajustaVirgula(TXTCHEQUE.Text)+'  ') ;
      if(TXTCREDITO.Text <> '')then
          IBQInicial.SQL.Add('and credito = '+FORM7.ajustaVirgula(TXTCREDITO.Text)+'  ') ;
      if(TXTDEBITO.Text <> '')then
          IBQInicial.SQL.Add('and debito = '+FORM7.ajustaVirgula(TXTDEBITO.Text)+'  ') ;
      if(TXTPROMISSORIA.Text <> '')then
          IBQInicial.SQL.Add('and promissoria = '+FORM7.ajustaVirgula(TXTPROMISSORIA.Text)+'  ') ;
     ShowMessage(IBQInicial.SQL.Text);
     IBQInicial.Active := True;
     result := True;
    end;
    Function TModeloForm11.Proximo():boolean;
    begin
      IBQInicial.Next;
      populaTXT();
      result := True;
    end;
    Function TModeloForm11.Anterior():boolean;
    begin
      IBQInicial.Prior;
      populaTXT();
      result := True;
    end;
    Function TModeloForm11.Primeiro():boolean;
    begin
      IBQInicial.First;
      populaTXT();
      result := True;
    end;
    Function TModeloForm11.Ultimo():boolean;
    begin
      IBQInicial.Last;
      populaTXT();
      result := True;
    end;
    Function TModeloForm11.SelectInicial():boolean;
    begin
       IBQInicial.Active := False;
       IBQInicial.SQL.Text := 'Select *from movimentodiario order by id';
       IBQInicial.Active := True;
       result := True;
    end;
    Function TModeloForm11.Buscard():Double;
    begin
       IBQuery3.Active := False;
       IBQuery3.SQL.Text := 'Select *from redleitura r where dtmovimento = '''+Form7.ajustaData(TXTDTMOVIMENTO.Text)+'''';
       IBQuery3.Active := True;
       result := IBQuery3.FieldByName('Vendabruta').AsFloat;
    end;


procedure TModeloForm11.FormCreate(Sender: TObject);
begin
  SelectInicial();
  PopulaTxt();

end;

procedure TModeloForm11.SpeedButton7Click(Sender: TObject);
begin
  inherited;
  Primeiro();
  PopulaTxt();
end;

procedure TModeloForm11.SpeedButton8Click(Sender: TObject);
begin
  inherited;
  Ultimo();
  PopulaTxt();
end;

procedure TModeloForm11.SpeedButton5Click(Sender: TObject);
begin
  inherited;
   Proximo();
   PopulaTxt();
end;

procedure TModeloForm11.SpeedButton6Click(Sender: TObject);
begin
  inherited;
  Anterior();
  PopulaTxt();
end;

procedure TModeloForm11.SpeedButton1Click(Sender: TObject);
begin
  inherited;
Limpa();
end;

procedure TModeloForm11.SpeedButton3Click(Sender: TObject);
begin
  inherited;
 If (Insert = True )then
    ShowMEssage('Movimento Diario cadastrado com sucesso')
 else
    ShowMEssage('ERRO ao cadastradar Movimento Diario !!');


end;

procedure TModeloForm11.SpeedButton2Click(Sender: TObject);
begin
  inherited;
   If (Altera = True )then
    ShowMEssage('Movimento Diario ALTERADO com sucesso')
 else
    ShowMEssage('ERRO ao ALTERAR Movimento Diario !!');
end;

procedure TModeloForm11.SpeedButton4Click(Sender: TObject);
begin
  inherited;
  Deleta();
  SelectInicial();
  PopulaTxt();
end;

procedure TModeloForm11.SpeedButton9Click(Sender: TObject);
begin
  inherited;
  Busca();
  PopulaTxt();
end;

procedure TModeloForm11.SpeedButton11Click(Sender: TObject);
begin
  inherited;
  ModeloForm12.ShowModal;
end;

end.
