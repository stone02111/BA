<fly:composition freeLayout="N">
	<fly:labelObject buddy="${formId}:databaseName" text="ODBC DSN 名称" width="30%" style="margin-bottom:10px;" />
	<fly:inputText id="${formId}:databaseName" name="${formId}:databaseName" type="text" value="${dbMeta.databaseName}" width="65%" style="margin-bottom:10px;" />
</fly:composition>
