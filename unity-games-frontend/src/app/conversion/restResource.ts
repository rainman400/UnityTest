

export interface gameRestRsrc {
    gameId?: number;
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
	images?: Array<imageRestRsrc>;
	tags?: string[];
    isPremium: boolean;
}

export interface imageRestRsrc {
    id?: string;
    url: string;
    type: number;
}

export interface categoryRsrc {
    id?: string;
    categoryText?: string;
}

export interface categoryListRsrc {
    categories?: categoryRsrc[]
}