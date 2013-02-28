unit UFrmRateio;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, DB, IBCustomDataSet, IBQuery, StdCtrls, Grids, DBGrids,
  ActCurrencyEdit, ExtCtrls, ActCustomEdit, ActNumberEdit, ActResultEdit,
  IBUpdateSQL, Buttons;

type
  TFrmRateio = class(TForm)
    Panel1: TPanel;
    Panel2: TPanel;
    Panel3: TPanel;
    ActResultEdit1: TActResultEdit;
    ActCurrencyEdit1: TActCurrencyEdit;
    DBGrid1: TDBGrid;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    QryConsProd: TIBQuery;
    IBQuery2: TIBQuery;
    Label5: TLabel;
    SpeedButton1: TSpeedButton;
    IBUpdateSQL1: TIBUpdateSQL;
    DataSource1: TDataSource;
    procedure ActResultEdit1DblClick(Sender: TObject);
    procedure SpeedButton1Click(Sender: TObject);
  private
    { Private declarations }
  public
    procedure inserir_dados(const a,b:Integer;c :Double );
  end;

var
  FrmRateio: TFrmRateio;
  NUM_ITEM,CODNFE :Integer;
  quantidade,soma :Double;
implementation

uses Unit1;

{$R *.dfm}

procedure TFrmRateio.inserir_dados(const a,b:Integer;c :Double );
begin
   NUM_ITEM :=  b;
   CODNFE   :=  a;
    quantidade := c;
    Label3.Caption := FloatToStr(c);
end;

procedure TFrmRateio.ActResultEdit1DblClick(Sender: TObject);
begin
QryConsProd.Active := False;
QryConsProd.ParamByName('CODPROD').AsInteger := StrToInt(ActResultEdit1.Text);
QryConsProd.Active := True;
if(not QryConsProd.Eof )then
  Label5.Caption := QryConsProd.FieldByNAme('DESCR_PRODUTO').AsString
else
  ShowMessage('Produto Inexistente');
end;

procedure TFrmRateio.SpeedButton1Click(Sender: TObject);
begin
IBQuery2.SQL.Clear;

IBQuery2.SQL.Add('insert into rateio');
IBQuery2.SQL.Add('  (COD_RATEIO, COD_PRODUTO, QUANTIDADE, NUM_ITEM, CODNFE)');
IBQuery2.SQL.Add('values');
IBQuery2.SQL.Add('  (:COD_RATEIO, :COD_PRODUTO, :QUANTIDADE, :NUM_ITEM, :CODNFE)');
IBQuery2.ParamByName('COD_RATEIO').AsInteger :=  NUM_ITEM;
IBQuery2.ParamByName('COD_PRODUTO').AsInteger := StrToInt(ActResultEdit1.Text);
IBQuery2.ParamByName('QUANTIDADE').AsFloat :=    StrToFloat(ActCurrencyEdit1.Text);
IBQuery2.ParamByName('NUM_ITEM').AsInteger :=    NUM_ITEM;
IBQuery2.ParamByName('CODNFE').AsInteger :=      CODNFE;
soma := soma +  StrToFloat(ActCurrencyEdit1.Text);
IBQuery2.ExecSQL;
IBQuery2.Transaction.Commit;
Label4.Caption := FloatToStr(soma);
end;

end.
