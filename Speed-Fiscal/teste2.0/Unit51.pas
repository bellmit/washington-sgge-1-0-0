unit Unit51;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Unit1, StdCtrls, Mask, DBCtrls, Buttons, U_DBBButton, ExtCtrls;

type
  TFRMXMATERIA = class(TForm1)
    Label1: TLabel;
    DBEdit1: TDBEdit;
    Label2: TLabel;
    DBEdit2: TDBEdit;
    Label3: TLabel;
    DBEdit3: TDBEdit;
    Label4: TLabel;
    DBEdit4: TDBEdit;
    Label5: TLabel;
    DBEdit5: TDBEdit;
    Label6: TLabel;
    DBEdit6: TDBEdit;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  FRMXMATERIA: TFRMXMATERIA;

implementation

uses Unit2;

{$R *.dfm}

end.
