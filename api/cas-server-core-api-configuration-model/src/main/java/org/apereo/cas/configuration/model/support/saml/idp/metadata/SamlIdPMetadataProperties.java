package org.apereo.cas.configuration.model.support.saml.idp.metadata;

import org.apereo.cas.configuration.support.RequiredProperty;
import org.apereo.cas.configuration.support.RequiresModule;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;

/**
 * This is {@link SamlIdPMetadataProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-saml-idp")
@Getter
@Setter
@Accessors(chain = true)
@JsonFilter("SamlIdPMetadataProperties")
public class SamlIdPMetadataProperties implements Serializable {

    private static final long serialVersionUID = -1020542741768471305L;

    /**
     * Core and common settings related to saml2 metadata management.
     */
    @NestedConfigurationProperty
    private SamlIdPMetadataCoreProperties core = new SamlIdPMetadataCoreProperties();

    /**
     * Forcefully download and fetch metadata files
     * form URL sources and disregard any cached copies
     * of the metadata.
     */
    private boolean forceMetadataRefresh = true;

    /**
     * Directory location where downloaded SAML metadata is cached
     * as backup files. If left undefined, the directory is calculated
     * off of {@link #getLocation()}. The directory location
     * should also support and be resolvable via Spring expression language.
     */
    private String metadataBackupLocation;

    /**
     * Directory location of SAML metadata and signing/encryption keys.
     * This directory will be used to hold the configuration files.
     */
    @RequiredProperty
    private String location = "file:/etc/cas/saml";
    
    /**
     * Properties pertaining to mongo db saml metadata resolvers.
     */
    @NestedConfigurationProperty
    private MongoDbSamlMetadataProperties mongo = new MongoDbSamlMetadataProperties();

    /**
     * Properties pertaining to redis saml metadata resolvers.
     */
    @NestedConfigurationProperty
    private RedisSamlMetadataProperties redis = new RedisSamlMetadataProperties();

    /**
     * Properties pertaining to git saml metadata resolvers.
     */
    @NestedConfigurationProperty
    private GitSamlMetadataProperties git = new GitSamlMetadataProperties();

    /**
     * Properties pertaining to jpa metadata resolution.
     */
    @NestedConfigurationProperty
    private JpaSamlMetadataProperties jpa = new JpaSamlMetadataProperties();

    /**
     * Properties pertaining to REST metadata resolution.
     */
    @NestedConfigurationProperty
    private RestSamlMetadataProperties rest = new RestSamlMetadataProperties();

    /**
     * Properties pertaining to AWS S3 metadata resolution.
     */
    @NestedConfigurationProperty
    private AmazonS3SamlMetadataProperties amazonS3 = new AmazonS3SamlMetadataProperties();

    /**
     * Properties pertaining to CouchDB metadata resolution.
     */
    @NestedConfigurationProperty
    private CouchDbSamlMetadataProperties couchDb = new CouchDbSamlMetadataProperties();

    /**
     * Metadata management settings via MDQ protocol.
     */
    @NestedConfigurationProperty
    private MDQSamlMetadataProperties mdq = new MDQSamlMetadataProperties();
}
