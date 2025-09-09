

---

### Dependencias de sistemas

**env vars**

```
  JAVA_VERSION: "zulu11"
  LIFERAY_WEB_PERIOD_SERVER_PERIOD_PROTOCOL: https
  LIFERAY_MODULE_PERIOD_FRAMEWORK_PERIOD_PROPERTIES_PERIOD_OSGI_PERIOD_CONSOLE: 0.0.0.0:11311
  LIFERAY_REDIRECT_PERIOD_URL_PERIOD_SECURITY_PERIOD_MODE: domain
  LIFERAY_WEB_PERIOD_SERVER_PERIOD_DISPLAY_PERIOD_NODE: "false"
  LIFERAY_JDBC_PERIOD_DEFAULT_PERIOD_DRIVER_UPPERCASEC_LASS_UPPERCASEN_AME: org.postgresql.Driver
  LIFERAY_JDBC_PERIOD_DEFAULT_PERIOD_URL: jdbc:postgresql://db-liferay-dev.c8xs56fw6u9w.eu-west-1.rds.amazonaws.com:5432/dbavanisdev
  LIFERAY_JDBC_PERIOD_DEFAULT_PERIOD_USERNAME: 'liferay'
  LIFERAY_JDBC_PERIOD_DEFAULT_PERIOD_PASSWORD: ***
```

**config**

- elastic config

VolumeMounts:
```
- name: elastic-conf
    mountPath: /opt/liferay/osgi/configs/com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration.config
    subPath: com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration.config
```
Config:
```
data:
  com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration.config: |
    operationMode="REMOTE"
    indexNamePrefix="liferay-"
    networkHostAddresses="elasticsearch:9200"
    clusterName="liferay_cluster"
    logExceptionsOnly="false"
```

**persistent volumes**

```
- name: files
    mountPath: /mnt/liferay/files
- name: war
    mountPath: /opt/liferay/osgi/war
- name: modules
    mountPath: /opt/liferay/osgi/modules
- name: document-library
    mountPath: /opt/liferay/data/document_library
```