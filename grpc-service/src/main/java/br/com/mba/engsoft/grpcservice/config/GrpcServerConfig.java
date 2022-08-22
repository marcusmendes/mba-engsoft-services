package br.com.mba.engsoft.grpcservice.config;

import io.grpc.netty.NettyServerBuilder;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfig {

    @Bean
    public GrpcServerConfigurer grpcServerConfigurer() {
        return serverBuilder -> {
            if (serverBuilder instanceof NettyServerBuilder) {
                ((NettyServerBuilder) serverBuilder)
                        .maxInboundMessageSize(1024 * 1024 * 50)
                        .maxInboundMetadataSize(1024 * 1024 * 50);
            }
        };
    }

}
