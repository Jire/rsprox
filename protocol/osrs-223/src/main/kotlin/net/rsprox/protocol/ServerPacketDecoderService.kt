package net.rsprox.protocol

import net.rsprot.buffer.JagByteBuf
import net.rsprot.compression.HuffmanCodec
import net.rsprot.protocol.message.IncomingMessage
import net.rsprox.protocol.game.outgoing.decoder.prot.ServerMessageDecoderRepository
import net.rsprox.protocol.session.Session

public class ServerPacketDecoderService(
    huffmanCodec: HuffmanCodec,
) : ServerPacketDecoder {
    @OptIn(ExperimentalStdlibApi::class)
    private val repository = ServerMessageDecoderRepository.build(huffmanCodec)

    override fun decode(
        opcode: Int,
        payload: JagByteBuf,
        session: Session,
    ): IncomingMessage {
        return repository
            .getDecoder(opcode)
            .decode(payload, session)
    }
}