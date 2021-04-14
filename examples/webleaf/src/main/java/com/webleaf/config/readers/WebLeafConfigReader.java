package com.webleaf.config.readers;

import com.webleaf.config.metadata.WebLeafMetadata;

public interface WebLeafConfigReader {
	WebLeafMetadata buildWebLeafConfig(String location);
}
