Drop database DBVehiculos2015530;

Create database DBVehiculos2015530;
Use DBVehiculos2015530;

create table Vehiculos(
	codigoVehiculo int auto_increment not null,
    marcaVehiculo varchar (50) not null,
    tipoVehiculo varchar (50) not null,
    estadoVehiculo varchar (50) not null,
    placaVehiculo varchar (50) not null,
    
    primary key PK_codigoVehiculo(codigoVehiculo)
);


Delimiter $$
	Create procedure sp_AgregarVehiculo (IN marcaVehiculo varchar (50), IN tipoVehiculo varchar (50), IN estadoVehiculo varchar (50), placaVehiculo varchar (50))
		Begin
			Insert into Vehiculos(marcaVehiculo, tipoVehiculo, estadoVehiculo, placaVehiculo)
				values (marcaVehiculo, tipoVehiculo, estadoVehiculo, placaVehiculo);
		End$$
Delimiter ;


call sp_AgregarVehiculo('Nissan', 'Sedan', 'Usado', '654BJS');
call sp_AgregarVehiculo('Honda', 'Hatchback', 'Nuevo', '456JKO');
call sp_AgregarVehiculo('Isuzu', 'Pickup', 'Usado', '854PLK');

select *from Vehiculos;