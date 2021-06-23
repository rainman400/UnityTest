

export interface vmGame {
    id?: number;
	category?: string;
	title?: string;
	subtitle?: string;
	description?: string;
	type?: number;
	author?: string;
	replayBundleUrl?: string;
	duration?: number;
	isDownloadable?: boolean;
	isStreamable?: boolean;
	version?: string;
	images?: vmImage[];
	tags?: string;
    isPremium? :boolean;
}

export interface vmGameList {
    games : vmGame[];
}


export interface vmImage {
    id?: string;
    url: string;
    type: number;
}

export interface vmCategory {
    id?: string;
    categoryText: string;
}


export interface vmCategoryList {
    categories : vmCategory[];
}

export interface errorMessage {
    error: string;
    message: string;
    status: string;
}
