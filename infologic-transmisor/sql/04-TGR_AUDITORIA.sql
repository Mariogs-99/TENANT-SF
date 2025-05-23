-----------------------------------------------------
--  DDL for Trigger TRG_AFT_RANGO_AUDIT_LOG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TRG_AFT_RANGO_AUDIT_LOG" 
AFTER INSERT OR UPDATE OR DELETE ON CNRPOS_RANGO
FOR EACH ROW
DECLARE
    V_OPERATION VARCHAR2(255);
    V_USER VARCHAR2(10);
    V_SUCURSAL VARCHAR2(100);
    V_CODIGO_SUCURSAL VARCHAR2(10);
BEGIN
   --OBTENER EL USUARIO QUE REALIZO LA OPERACION
    V_USER := :NEW.USUARIO;

    --OBTENER INFORMACION DE LA SUCURSAL A LA QUE SE LE ESTA MODIFICANDO O AGREGANDO EL RANGO
    SELECT NOMBRE_SUCURSAL, CODIGO_SUCURSAL INTO V_SUCURSAL, V_CODIGO_SUCURSAL FROM CNRPOS_SUCURSAL WHERE ID_SUCURSAL = :NEW.ID_SUCURSAL;
    -- Determinar el tipo de operación
    IF INSERTING THEN
        V_OPERATION := 'SE AGREGO UN NUEVO RANGO DE' || V_SUCURSAL || ' ' || V_CODIGO_SUCURSAL;

    ELSIF UPDATING THEN
        V_OPERATION := 'SE MODIFICO RANGO DE' || V_SUCURSAL || ' ' || V_CODIGO_SUCURSAL;
    END IF;
     -- Insertar el log en la tabla de auditoría
     INSERT INTO CNRPOS_AUDIT_LOG (TABLE_NAME, OPERATION, USER_NAME)
    VALUES ('CNRPOS_RANGO', V_OPERATION, V_USER);
END;
/
--------------------------------------------------------
--  DDL for Trigger TRG_AFT_SUCURSALES_AUDIT_LOG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TRG_AFT_SUCURSALES_AUDIT_LOG" 
AFTER INSERT OR UPDATE OR DELETE ON CNRPOS_SUCURSAL
FOR EACH ROW
DECLARE
    V_OPERATION VARCHAR2(255);
    V_USER VARCHAR2(10);
BEGIN
   --OBTENER EL USUARIO QUE REALIZO LA OPERACION
    V_USER := :NEW.USUARIO;
    -- Determinar el tipo de operación
    IF INSERTING THEN
        V_OPERATION := 'SE AGREGO NUEVA SUCURSAL ' || :NEW.NOMBRE_SUCURSAL || ' ' || :NEW.CODIGO_SUCURSAL;

    ELSIF UPDATING THEN
        IF :NEW.DELETED_AT IS  NULL THEN
            V_OPERATION := 'SE MODIFICO SUCURSAL ' || :NEW.NOMBRE_SUCURSAL || ' ' || :NEW.CODIGO_SUCURSAL;           
        ELSIF :NEW.DELETED_AT IS NOT NULL THEN
            V_OPERATION := 'SE DESHABILITO SUCURSAL ' || :NEW.NOMBRE_SUCURSAL || ' ' || :NEW.CODIGO_SUCURSAL;
        END IF;
    END IF;
     -- Insertar el log en la tabla de auditoría
     INSERT INTO CNRPOS_AUDIT_LOG (TABLE_NAME, OPERATION, USER_NAME)
    VALUES ('CNRPOS_SUCURSAL', V_OPERATION, V_USER);
END;
/
--------------------------------------------------------
--  DDL for Trigger TRG_AFT_TRANSACCION_AUDIT_LOG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TRG_AFT_TRANSACCION_AUDIT_LOG" 
AFTER INSERT OR UPDATE OR DELETE ON CNRPOS_TRANSACCION
FOR EACH ROW
DECLARE
    V_OPERATION VARCHAR2(255);
    V_USER VARCHAR2(10);
BEGIN
   --OBTENER EL USUARIO QUE REALIZO LA OPERACION
    SELECT USUARIO INTO V_USER FROM CNRPOS_USERS WHERE ID_USER = :NEW.ID_USER;
    -- Determinar el tipo de operación
    IF INSERTING THEN
        V_OPERATION := 'SE AGREGO NUEVA TRANSACCION VENTA TIPO_DTE ' || :NEW.TIPO_DTE;
        -- Insertar el log en la tabla de auditoría
        INSERT INTO CNRPOS_AUDIT_LOG (TABLE_NAME, OPERATION, USER_NAME)
        VALUES ('CNRPOS_TRANSACCION', V_OPERATION, V_USER);
    ELSIF UPDATING THEN
        IF :NEW.STATUS = 7 THEN
            V_OPERATION := 'SE INVALIDO LA TRANSACCION VENTA TIPO_DTE ' || :NEW.TIPO_DTE;
            -- Insertar el log en la tabla de auditoría
            INSERT INTO CNRPOS_AUDIT_LOG (TABLE_NAME, OPERATION, USER_NAME)
            VALUES ('CNRPOS_TRANSACCION', V_OPERATION, V_USER);
        END IF;
    END IF;   
END;
/
--------------------------------------------------------
--  DDL for Trigger TRG_BI_CNRPOS_AUDIT_LOG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TRG_BI_CNRPOS_AUDIT_LOG" 
BEFORE INSERT ON CNRPOS_AUDIT_LOG
FOR EACH ROW
BEGIN
  :NEW.ID := CNRPOS_AUDIT_LOG_SEQ.NEXTVAL;
END;