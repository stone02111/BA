<fly:composition>
	<fly:layout type="float">
		<fly:layoutItem>
			<fly:labelObject title="标识符" type="fieldset">
				<fly:layout type="float" column="2">
					<fly:layoutItem>
						<fly:labelObject for="${formId}:SUPPORTS_BOOLEAN_DATA_TYPE" title="支持布尔数据类型" labelWidth="70%">
							<fly:inputText id="${formId}:SUPPORTS_BOOLEAN_DATA_TYPE" name="${formId}:SUPPORTS_BOOLEAN_DATA_TYPE" type="checkbox" value="${dbMeta.attributes['SUPPORTS_BOOLEAN_DATA_TYPE']}" />
						</fly:labelObject>
					</fly:layoutItem>
					<fly:layoutItem>
						<fly:labelObject for="${formId}:QUOTE_ALL_FIELDS" title="标识符使用引号括起来" labelWidth="70%">
							<fly:inputText id="${formId}:QUOTE_ALL_FIELDS" name="${formId}:QUOTE_ALL_FIELDS" type="checkbox" value="${dbMeta.attributes['QUOTE_ALL_FIELDS']}" />
						</fly:labelObject>
					</fly:layoutItem>
					<fly:layoutItem>
						<fly:labelObject for="${formId}:FORCE_IDENTIFIERS_TO_LOWERCASE" title="强制标识符使用小写字母" labelWidth="70%">
							<fly:inputText id="${formId}:FORCE_IDENTIFIERS_TO_LOWERCASE" name="${formId}:FORCE_IDENTIFIERS_TO_LOWERCASE" type="checkbox" value="${dbMeta.attributes['FORCE_IDENTIFIERS_TO_LOWERCASE']}" />
						</fly:labelObject>
					</fly:layoutItem>
					<fly:layoutItem>
						<fly:labelObject for="${formId}:FORCE_IDENTIFIERS_TO_UPPERCASE" title="强制标识符使用大写字母" labelWidth="70%">
							<fly:inputText id="${formId}:FORCE_IDENTIFIERS_TO_UPPERCASE" name="${formId}:FORCE_IDENTIFIERS_TO_UPPERCASE" type="checkbox" value="${dbMeta.attributes['FORCE_IDENTIFIERS_TO_UPPERCASE']}" />
						</fly:labelObject>
					</fly:layoutItem>
				</fly:layout>
			</fly:labelObject>
		</fly:layoutItem>
		<fly:layoutItem>
			<fly:labelObject for="${formId}:preferredSchemaName" title="默认模式名称（在没有其他模式名时使用）" type="labelSingle">
				<fly:inputText id="${formId}:preferredSchemaName" name="${formId}:preferredSchemaName" style="width:100%;" type="text" value="${dbMeta.preferredSchemaName}" />
			</fly:labelObject>
		</fly:layoutItem>
		<fly:layoutItem>
			<fly:labelObject for="${formId}:connectionType" title="请输入连接成功后要执行的SQL语句，用分号(;)隔开" type="labelSingle">
				<textarea id="${formId}:connectSQL" name="${formId}:connectSQL" style="width:100%;" rows="6">
					${dbMeta.connectSQL}
				</textarea>
			</fly:labelObject>
		</fly:layoutItem>
	</fly:layout>
</fly:composition>